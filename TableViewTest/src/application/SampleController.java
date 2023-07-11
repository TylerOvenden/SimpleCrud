package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import application.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable {

	  @FXML
	    private TableView<Student> students;

	    @FXML
	    private TableColumn<Student, Integer> idCol;

	    @FXML
	    private TableColumn<Student, String> firstCol;

	    @FXML
	    private TableColumn<Student, String> lastCol;


	    @FXML
	    private TextField firstField;

	    @FXML
	    private TextField lastField;

	    @FXML
	    private TextField idField;

	
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub
		firstCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
		lastCol.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		idCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        setupTable();
	}
	
	 private void setupTable(){
		 
		 Student s0 = new Student("Jeff","Smith",123 );
		 Student s1 = new Student("John","Willaims",300);
	      students.getItems().addAll(s0, s1);
	 }
	  @FXML
	    void rowClicked(MouseEvent event) {
		  
		  
	  }
	  @FXML 
	  void remove(ActionEvent event) {
		  if (students.getSelectionModel().getSelectedItem() != null) {
		        int removeID = students.getSelectionModel().getSelectedIndex();
		        students.getItems().remove(removeID);
		    }
		  
	  }
	  
	  
	  @FXML 
	  void edit(ActionEvent event) {
		  if (students.getSelectionModel().getSelectedItem() != null) {
			    Student selectedStudent = students.getSelectionModel().getSelectedItem();
			    selectedStudent.setFirstName(firstField.getText());
			    selectedStudent.setLastName(lastField.getText());
			    selectedStudent.setId(Integer.parseInt(idField.getText()));   
			  //  students.setItems(selectedStudent);
			    students.refresh();
		  }
		  
	  }
	  @FXML 
	  void addStudent(ActionEvent event)
	  {
		   int currentId = Integer.parseInt(idField.getText());
		    String currentFirst = firstField.getText();
		    String currentLast = lastField.getText();
		    Student s0 = new Student(currentFirst, currentLast,currentId );
		   // Animal newAnimal = new Animal(currentAnimalId, currentAnimalType, currentAnimalName);
		    students.getItems().add(s0);
		    
	  }	  
	  
}
