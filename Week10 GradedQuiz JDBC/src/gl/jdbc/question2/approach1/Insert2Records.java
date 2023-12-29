package gl.jdbc.question2.approach1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert2Records {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/GL";
    static final String USER_NAME = "root";
    static final String PASS = "root";
    
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASS);
            preparedStatement = connection.prepareStatement("INSERT INTO employee (Id, Name, Email_Id, Phone_Number) VALUES (?, ?, ?, ?)");
            
            // Insert 2 additional records
            InsertRecords.insertRecord(preparedStatement, 6, "Eva Davis", "eva@example.com", "1112223333");
            InsertRecords.insertRecord(preparedStatement, 7, "Frank White", "frank@example.com", "4445556666");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
