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
 * class for updating entries based on the selected student id (assumed that 
 * the student ids would be unique to each entry)
 * user decides what attribute they want to change, either the graduation year or 
 * student rank
 * 
 * */


public class JDBC_Update {

	public static void main(String[] args)throws SQLException {
		String DELETE_QUERY = "UPDATE UNIVERSITY SET STUDENT_RANK=? WHERE STUDENT_ID=?";
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
			//user decides if 
			System.out.println("enter 1 if you want to change the rank, "
					+ "2 if you want to change the graduation_year");
			
			int decision = inp.nextInt();
		
			//need to change the query if not changing the rank 
			if(decision != 1) 
				DELETE_QUERY = "UPDATE UNIVERSITY SET GRADUATION_YEAR=? WHERE STUDENT_ID=?";
				
			
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);{
			
		
				System.out.println("enter a student id from the table");
				int id = inp.nextInt();
				
				if(decision == 1) {
					System.out.println("enter a new student rank");
					int rank = inp.nextInt();	
					ps.setInt(1, rank);
				}
				else if(decision == 2) {
				
					System.out.println("enter a new graduation year");
					int grad = inp.nextInt();	
					ps.setInt(1, grad);
				}
			
			//student id being used as the identifier regardless of what is being changed	
				ps.setInt(2,id);
			
				int count = ps.executeUpdate();
				//checks done to confirm if the instruction successfully executed 
				if(count == 0) 
					System.out.println("query wasn't executed, no update");
					
				
				else
					System.out.println("query executed & entry updated");
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
