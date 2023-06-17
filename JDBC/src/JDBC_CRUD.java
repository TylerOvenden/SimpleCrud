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

/*
 * combines the 4 classes into one that does create, delete, display & updating operations
 * 
 * */

public class JDBC_CRUD {


	public static void main(String[] args)throws SQLException {
		String QUERY = "SELECT * FROM university";
		try (Scanner inp = new Scanner(System.in)) {
			String url = "jdbc:mysql://localhost:3306/University";
			String username = "root";
			String password = "jeffdoge8";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			for(int j = 0; j<5;j++) {
			try(Connection con = DriverManager.getConnection(url, username, password)) {

			
				System.out.println("enter 1 if you want to display "
						+ "2 if you want to create a new entry" + " enter 3 if you want to update an entry & 4 if you want to delete an entry");
				
				int decision = inp.nextInt();
				if(decision == 1) {
					QUERY = "SELECT * FROM university";
					Statement state = con.createStatement();
					ResultSet rs = state.executeQuery(QUERY);
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
				else if(decision == 2) {
					QUERY = "INSERT INTO UNIVERSITY(FIRST_NAME,LAST_NAME,STUDENT_ID,GRADUATION_YEAR,STUDENT_RANK) VALUES(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(QUERY);{
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
				else if(decision == 3) {
					QUERY = "UPDATE UNIVERSITY SET STUDENT_RANK=? WHERE STUDENT_ID=?";
					System.out.println("enter 1 if you want to change the rank, "
							+ "2 if you want to change the graduation_year");
					
					decision = inp.nextInt();
				
					//need to change the query if not changing the rank 
					if(decision != 1) 
						QUERY = "UPDATE UNIVERSITY SET GRADUATION_YEAR=? WHERE STUDENT_ID=?";
						
					
					PreparedStatement ps = con.prepareStatement(QUERY);{
					
				
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
				else {
					QUERY = "DELETE FROM UNIVERSITY WHERE LAST_NAME = ?";
					PreparedStatement ps = con.prepareStatement(QUERY);{
								
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
				}	
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			}
		}	
	}
}