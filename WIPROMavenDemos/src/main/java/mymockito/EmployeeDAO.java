package mymockito;
import java.util.Collections;
import java.util.List;

public class EmployeeDAO {
	private static EmployeeDAO employeeDAO = new EmployeeDAO();

	/*
	 * private constructor. No objects of this class be created with new
	 * EmployeeDAO(). Use getInstance() instead
	 */
	private EmployeeDAO() {
	}

	// static method to create object
	public static EmployeeDAO getInstance() {
		return employeeDAO;//ONLY STATIC TYPE
	}
	// get employee
	public Employee getEmployee(Long employeeId) {
		return null;
	}

	// list all employees
	//Collection is a built in class!
	public List<Employee> getAll() {
		return Collections.emptyList();
	}
	public String addEmployee(Employee employee) {
		return employee.getEmployeeName();//returning empname
	}
	
	// update employee
	public String updateEmployee(Employee employee) {
		return employee.getEmployeeName();//returning empname
	}
	// delete employee
	public String deleteEmployee(Long employeeId) {
		return null;
	}
	// get points
	public int getPoints(Long employeeId) {
		return 0;
	}

}
