package application;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	
	public Student(String firstName, String lastName, int id) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
//	     setupTable();
	}
	


	// Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
