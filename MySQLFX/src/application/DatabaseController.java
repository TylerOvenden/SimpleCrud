package application;


import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.sql.DriverManager;
//converts
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//result of query
import java.sql.SQLException;
import java.sql.Statement;

//statement sent to server
import java.util.Scanner;  // Import the Scanner class



public class DatabaseController {
//STUDENT_ID
	
	@FXML
	private Label lbl;
	
	@FXML
	private Button button;
	
	
	
	public void clickButton(ActionEvent event) throws ClassNotFoundException {
	DatabaseConnector connectNow = new DatabaseConnector();	
	String QUERY = "SELECT LAST_NAME FROM university";
	Connection con = connectNow.getConnection();
	try {
		
		Statement s = con.createStatement();
		ResultSet rs =  s.executeQuery(QUERY);
		
		while(rs.next()) {
			lbl.setText(rs.getString("LAST_NAME"));
		}
		
		
		}
		
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
