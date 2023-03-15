package assignment1;

public class Manager extends Employee {
	private String secretary;
	
	
	//constructor
	public Manager(String manager_first, String manager_last, String manager_hire_day,
			Double manager_s, String manager_secretary) {
		super(manager_first, manager_last, manager_hire_day, manager_s); secretary = manager_secretary;
	}
	
	// Accessor and setter of secretary
	public String getSecretary() {
		return secretary;
	}
	public void setSecretary(String s) {
		secretary = s;
	}
	public String toString() {
		return "Name: " + first_name + last_name + " Hire day: "
				+ hire_day + " Salary: " +salary + " Secretary: " + secretary;
	}
}
