package application;
import java.sql.Connection;

//connects to database
import java.sql.DriverManager;
//converts
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//result of query
import java.sql.SQLException;
import java.sql.Statement;

//statement sent to server
import java.util.Scanner;  // Import the Scanner class


public class DatabaseConnector {
	public Connection databaseLink;
	public Connection getConnection() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/University";
		String username = "root";
		String password = "jeffdoge8";
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				databaseLink = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return databaseLink;
		
	}
}
