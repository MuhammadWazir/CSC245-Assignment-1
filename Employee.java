package assignment1;

public class Employee {
	//characteristics
	protected String first_name;
	protected String last_name;
	protected String hire_day;
	protected Double salary;
	
	//constructor
	public Employee(String f, String l, String h, Double s) {
		first_name = f; last_name = l; hire_day = h; salary = s;
	}
	
	
	//getters
	public String getFirst() {
		return first_name;
	}
	public String getLast() {
		return last_name;
	}
	public String getHireDay(){
		return hire_day;
	}
	public double getSalary(){
		return salary;
	}
	
	
	//setters
	public void setFirst(String first) {
		first_name = first;
	}
	public void setLast(String last) {
		last_name = last;
	}
	public void setHireDay(String date) {
		hire_day = date;
	}
	public void setSalary(double s) {
		salary = s;
	}
	
	//test for equality
	public boolean equal(Employee emp2) {
		return (first_name.equals(emp2.first_name)) &&
		((last_name).equals(emp2.last_name));
	}
	
	public String toString() {
		return "Name: " + first_name + last_name + " Hire day: "
				+ hire_day + " Salary: " +salary;
	}
}

