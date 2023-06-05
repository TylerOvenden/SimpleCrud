import java.sql.Connection;

//connects to database
import java.sql.DriverManager;
//converts

import java.sql.ResultSet;
//result of query
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

//statement sent to server
import java.util.Scanner;  // Import the Scanner class

/*
 * class for deleting a student entry from the university table
 * selects the entries to delete by the last name the user entered.
 * If multiple entries have the same last name field, they will all be deleted 
 * 
 * */

public class JDBC_Delete {
	public static final String DELETE_QUERY = "DELETE FROM UNIVERSITY WHERE LAST_NAME = ?";
	public static void main(String[] args)throws SQLException {
		Scanner inp = new Scanner(System.in);
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
	
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);{
				
				System.out.println("enter the last name of the entry/entries to delete");
				String lastName = inp.next();
				ps.setString(1, lastName);
			
				int count = ps.executeUpdate();
				//checks done to confirm if the instruction successfully executed 
				if(count == 0) 
					System.out.println("query wasn't executed, no deletion");
					
				
				else
					System.out.println("query executed & entry/entries deleted");
			}
			/*
			Connection con = DriverManager.getConnection(url, username, password);
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(query);
			while(rs.next()) {
				String text = "";
				for(int i = 1; i<= 5;i++) {
					text += rs.getString(i) + ":";
				}
				System.out.println(text);
			}
			*/
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
