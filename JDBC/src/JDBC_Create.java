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
 * class for creating a new table entry of a university student to 
 * a previously made MySQL database.
 * The data stores are the student's first & last names, student id, graduation year & rank
 * 
 * */


public class JDBC_Create {
	public static final String INSERT_QUERY = "INSERT INTO UNIVERSITY(FIRST_NAME,LAST_NAME,STUDENT_ID,GRADUATION_YEAR,STUDENT_RANK) VALUES(?,?,?,?,?)";
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
	
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);{
				System.out.println("enter a first name");
				String firstName = inp.next();
				ps.setString(1, firstName);
				System.out.println("enter a last name");
				String lastName = inp.next();
				ps.setString(2, lastName);

				System.out.println("enter a student ID number");
				int id = inp.nextInt();
				ps.setInt(3, id);
				System.out.println("enter a graduation year");
				int grad = inp.nextInt();
				ps.setInt(4, grad);
				System.out.println("enter the student's ranking");
				int rank = inp.nextInt();
				ps.setInt(5, rank);
		
				//exe
				int count = ps.executeUpdate();
				//checks done to confirm if the instruction successfully executed 
				if(count == 0) 
					System.out.println("did not execute");
				
				else
					System.out.println("query executed");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
