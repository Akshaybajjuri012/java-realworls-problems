package jdbcdemo;
import java.sql.*;
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}
class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("%d - %s - %s - %.2f", id, name, department, salary);
    }
}
class EmployeeService {

    public void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Invalid salary: " + salary + ". Salary cannot be negative.");
        }
    }

    public void processSalary(Employee emp) throws InvalidSalaryException {
        validateSalary(emp.getSalary());
        System.out.println("Salary processed for: " + emp.getName());
    }

    public void startProcess(Employee emp) throws InvalidSalaryException {
        processSalary(emp);
    }
}
public class EmployeeSalaryValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Employee employee = null;

	        String url = "jdbc:mysql://localhost:3306/employee_db";
	        String user = "root";
	        String password = "Akshay@9100";

	        try (Connection conn = DriverManager.getConnection(url, user, password)) {
	            String sql = "SELECT * FROM employees WHERE salary < 0 LIMIT 1";
	            try (PreparedStatement stmt = conn.prepareStatement(sql);
	                 ResultSet rs = stmt.executeQuery()) {

	                if (rs.next()) {
	                    int id = rs.getInt("id");
	                    String name = rs.getString("name");
	                    double salary = rs.getDouble("salary");
	                    String department = rs.getString("department");

	                    employee = new Employee(id, name, salary, department);
	                } else {
	                    System.out.println("No employee with negative salary found.");
	                    return;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return;
	        }
	        EmployeeService service = new EmployeeService();
	        try {
	            service.startProcess(employee);
	        } catch (InvalidSalaryException e) {
	            System.err.println("Error processing employee salary: " + e.getMessage());
	            }

	}

}
