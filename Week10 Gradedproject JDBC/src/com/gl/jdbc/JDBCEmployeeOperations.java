package com.gl.jdbc;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEmployeeOperations {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/GL";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // JDBC connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // a. Insert 5 records
            insertRecords(connection);

            // b. Modify Email_Id column to varchar(30) NOT NULL
            modifyEmailColumn(connection);

            // c. Insert 2 records and check
            insertRecords(connection);

            // d. Update the name of employee Id 3 to Karthik and phone number to 1234567890
            updateEmployeeDetails(connection, 3, "Karthik", "1234567890");

            // e. Delete employee records 3 and 4
            deleteEmployeeRecords(connection, 3);
            deleteEmployeeRecords(connection, 4);

            // f. Remove all records from the table employee
            removeAllRecords(connection);

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertRecords(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO employee (Name, Email_Id, Phone_Number) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Insert 5 records
            for (int i = 1; i <= 5; i++) {
                preparedStatement.setString(1, "Employee" + i);
                preparedStatement.setString(2, "email" + i + "@example.com");
                preparedStatement.setString(3, "123456789" + i);

                preparedStatement.executeUpdate();
            }
        }
    }

    private static void modifyEmailColumn(Connection connection) throws SQLException {
        String alterQuery = "ALTER TABLE employee MODIFY Email_Id VARCHAR(30) NOT NULL";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(alterQuery);
        }
    }

    private static void updateEmployeeDetails(Connection connection, int employeeId, String newName, String newPhoneNumber) throws SQLException {
        String updateQuery = "UPDATE employee SET Name = ?, Phone_Number = ? WHERE Id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newPhoneNumber);
            preparedStatement.setInt(3, employeeId);

            preparedStatement.executeUpdate();
        }
    }

    private static void deleteEmployeeRecords(Connection connection, int... employeeIds) throws SQLException {
        String deleteQuery = "DELETE FROM employee WHERE Id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            for (int employeeId : employeeIds) {
                preparedStatement.setInt(1, employeeId);
                preparedStatement.executeUpdate();
            }
        }
    }

    private static void removeAllRecords(Connection connection) throws SQLException {
        String deleteAllQuery = "DELETE FROM employee";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(deleteAllQuery);
        }
    }
}
