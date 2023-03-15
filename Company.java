/*Name: Muhammad El Wazir
 * id: 202204951
 * Last modified: February 5
 * code description: created class Company with 5 methods (addEmployee(), deleteEmployee() 
 * raiseSalary(), listAll(), and main()). The program terminates when the user inputs 5.
 * Files: Manager, Employee
 */
package assignment1;
import java.util.Scanner;
public class Company {
	private Employee[] employees;
	private int attempt;
	
	//constructor
	public Company(int size) {
		employees = new Employee[size];
	}
	
	//method to add an employee
	public void addEmployee() {
		/*takes input for name, salary, hire day.
		 * Asks whether the employee is a manager. If so, prompts for the name of the secretary
		 * tests if the employee is already present.
		 * validates input for 5 times then exits
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter employee's name, (first, last): ");
		String name = scan.nextLine();
		String[] parts = name.split(",");
		String first = parts[0].trim();
		String last = parts.length > 1 ? parts[1].trim() : "";
		
		System.out.print("Enter hire day: ");
		String hire_day = scan.nextLine();
		
		System.out.print("Enter salary: ");
		double salary = scan.nextDouble();
		
		System.out.print("Is the employee a manager? (y/n) ");
		String is_manager = scan.next();
		
		Employee new_employee;
		if (is_manager.toLowerCase().equals("y")) {
			Scanner scan_secretary = new Scanner(System.in);
			System.out.print("What is the name of the secretary? ");
			String secretaryName = scan_secretary.nextLine();
			new_employee = new Manager(first, last, hire_day, salary, secretaryName);
		} else {
			new_employee = new Employee(first, last, hire_day, salary);
		}
		
		attempt = 0;
		for (int i = 0; i < employees.length; i++) {
		  if (employees[i] != null) {
		    while (employees[i].equal(new_employee) && attempt < 5) {
		      Scanner scan_2 = new Scanner(System.in);
		      System.out.println("Employee already exists, try again");
		      name = scan_2.nextLine();
		      parts = name.split(",");
		      first = parts[0].trim();
		      last = parts.length > 1 ? parts[1].trim() : "";
		      new_employee.setFirst(first);
		      new_employee.setLast(last);
		      attempt++;
		    }
		      if (attempt == 5) {
		        System.out.println("Too many attempts, exiting program");
		        break;
		      }
		      
		   }
		  else {
			employees[i] = new_employee;
			  break;
		}
		}
		 
	}
	
	//method to delete employee
	public void deleteEmployee() {
		/*prompts for name
		 * validates name
		 * deletes employee
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the employee you'd like to delete"
							+ " (first, last): ");
		String name = scan.nextLine();
		String[] parts = name.split(",");
		String first = parts[0].trim();
		String last = parts.length > 1 ? parts[1].trim() : "";
		
		boolean is_found = false;
		for (Employee employee : employees) {
		    if (employee != null) {
		        if (employee.getFirst().equals(first) && employee.getLast().equals(last)) {
		            is_found = true;
		            System.out.println("Employee is deleted");
		            break;
		        }
		    }
		}

		if (is_found == true) {
		    for (int i = 0; i < employees.length; i++) {
		        if (employees[i] != null && employees[i].getFirst().equals(first)
		            && employees[i].getLast().equals(last)) {
		            employees[i] = null;
		            break;
		        }
		    }
		}

		
		
		attempt = 0;
		
			while(attempt < 5 && is_found == false) {
				Scanner scan_again = new Scanner(System.in);
				System.out.println("Employee doesn't exist, try again: ");
				name = scan_again.nextLine();
				parts = name.split(",");
				first = parts[0].trim();
				last = parts.length > 1 ? parts[1].trim() : "";
				for (Employee employee : employees) {
				    if (employee != null) {
				        if (employee.getFirst().equals(first) && employee.getLast().equals(last)) {
				            is_found = true;
				            System.out.println("Employee is deleted");
				            break;
				        }
				    }
				}

				if (is_found == true) {
				    for (int i = 0; i < employees.length; i++) {
				        if (employees[i] != null && employees[i].getFirst().equals(first)
				            && employees[i].getLast().equals(last)) {
				            employees[i] = null;
				            break;
				        }
				    }
				}

				attempt++;
		  }
	}
	
	//method to raise salary
	public void raiseSalary() {
		/*prompts for the name and the raise percentage.
		 * validates name.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the employee "
							+ " (first, last): ");
		String name = scan.nextLine();
		String[] parts = name.split(",");
		String first = parts[0].trim();
		String last = parts.length > 1 ? parts[1].trim() : "";
		
		System.out.print("Enter the raise percentage: ");
		double raise = scan.nextDouble();
		
		
		boolean is_found = false;
		for (Employee employee : employees) {
		    if (employee != null) {
		        if (employee.getFirst().equals(first) && employee.getLast().equals(last)) {
		            is_found = true;
		            break;
		        }
		    }
		}

		if (is_found == true) {
		    for (int i = 0; i < employees.length; i++) {
		        if (employees[i] != null && employees[i].getFirst().equals(first)
		            && employees[i].getLast().equals(last)) {
		        	if(employees[i] instanceof Manager) {
		        		employees[i].setSalary((employees[i].getSalary()
        						+ employees[i].getSalary()*raise)*1.02);
		        	}
		        	else {
		        		employees[i].setSalary(employees[i].getSalary()
		            						+ employees[i].getSalary()*raise);
		        	}
		            break;
		        }
		    }
		}
		attempt = 0;
		while(attempt < 5 && is_found == false) {
			Scanner scan_again = new Scanner(System.in);
			System.out.println("Employee doesn't exist, try again: ");
			name = scan_again.nextLine();
			parts = name.split(",");
			first = parts[0].trim();
			last = parts.length > 1 ? parts[1].trim() : "";
			for (Employee employee : employees) {
			    if (employee != null) {
			        if (employee.getFirst().equals(first) && employee.getLast().equals(last)) {
			            is_found = true;
			            break;
			        }
			    }
			}

			if (is_found == true) {
			    for (int i = 0; i < employees.length; i++) {
			        if (employees[i] != null && employees[i].getFirst().equals(first)
			            && employees[i].getLast().equals(last)) {
			        	if(employees[i] instanceof Manager) {
			        		employees[i].setSalary((employees[i].getSalary()
	        						+ employees[i].getSalary()*raise)*1.02);
			        	}
			        	else {
			        		employees[i].setSalary(employees[i].getSalary()
			            						+ employees[i].getSalary()*raise);
			        	}
			            break;
			        }
			    }
			}

			attempt++;
	  }
		
	}
	
	//method to list all employees
	public void listAll() {
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] != null) {
				System.out.println(employees[i]);
			}
		}
	}
	
	//menu
	public void main() {
		Scanner scan_input = new Scanner(System.in);
		System.out.print("\r\n1.Add employee\r\n"
				+ "2.Delete employee\r\n"
				+ "3.Raise salary\r\n"
				+ "4.List all\r\n"
				+ "5.Exit\r\n"
				+ "----------------------\r\n"
				+ "Enter your choice:\r\n");
		int input = scan_input.nextInt();
		
		while (input != 5) {
			if (input == 1) {
				addEmployee();
				if (attempt == 5) {
					return;
				}
				
			}
			if (input == 2) {
				deleteEmployee();
				if (attempt == 5) {
					System.out.println("Too many attempts, exiting program");
					return;
				}
				
			}
			else if (input == 3) {
				raiseSalary();
				if (attempt == 5) {
					System.out.println("Too many attempts, exiting program");
					return;
				}
			}
			else if (input == 4){
					listAll();
			}
			Scanner scan_again = new Scanner(System.in);
			System.out.print("1.Add employee\r\n"
						+ "2.Delete employee\r\n"
						+ "3.Raise salary\r\n"
						+ "4.List all\r\n"
						+ "5.Exit\r\n"
						+ "----------------------\r\n"
						+ "Enter your choice:\r\n");
			input = scan_again.nextInt();
		}
	}
	public static void main(String[] args) {
		Company my_company = new Company(70);
		my_company.main();
	}
}
