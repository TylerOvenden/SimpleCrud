import java.sql.Connection;

//connects to database
import java.sql.DriverManager;
//converts

import java.sql.ResultSet;
//result of query
import java.sql.SQLException;
import java.sql.Statement;

//statement sent to server
import java.util.Scanner;  // Import the Scanner class

/*
 * class that calls a query for displaying all entries in the university table
 * */

public class JDBC_Display {

	//public static final String DISPLAY_QUERY = "SELECT * FROM university";
	public static void main(String[] args)throws SQLException {
		String DISPLAY_QUERY = "SELECT * FROM university";
		String url = "jdbc:mysql://localhost:3306/University";
		String username = "root";
		String password = "jeffdoge8";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection(url, username, password)) {
	
		
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(DISPLAY_QUERY);
		//will loop while there's another resultset (loops through every entry)
			while(rs.next()) {
				String text = "";
		//loops 5 times because of the 5 attributes to each entry 
				for(int i = 1; i<= 5;i++) {
					text += rs.getString(i) + ":";
				}
				System.out.println(text);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}