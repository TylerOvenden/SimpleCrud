module TableViewTest {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens application to javafx.base, javafx.graphics, javafx.fxml;
}
