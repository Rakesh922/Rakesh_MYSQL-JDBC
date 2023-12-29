package com.gl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCEmployeeInsert {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/MYSQL_PROJECT";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // JDBC connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Insert 5 records
            insertRecords(connection);

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
            System.out.println("Records inserted successfully.");
        }
    }
}
