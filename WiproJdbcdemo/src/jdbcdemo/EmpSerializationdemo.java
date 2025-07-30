package jdbcdemo;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    String emp_id;
    String emp_name;
    transient double emp_salary; 
    public Employee(String emp_id, String emp_name, double emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
    }

    public void display() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Salary: " + emp_salary);
    }
}
public class EmpSerializationdemo {
	static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "Akshay@9100";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(id, name, salary);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emp.ser"))) {
            out.writeObject(emp);
            System.out.println("\nEmployee serialized to emp.ser (salary excluded).");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize and show result (salary = 0.0)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp.ser"))) {
            Employee deserialized = (Employee) in.readObject();
            System.out.println("\nDeserialized Employee:");
            deserialized.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        insertIntoEmpTable(emp);

        // Fetch and show from database
        fetchFromEmpTable(emp.emp_id);

        scanner.close();
    }
	 static void insertIntoEmpTable(Employee emp) {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	            String sql = "INSERT INTO emp (emp_id, emp_name, emp_salary) VALUES (?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, emp.emp_id);
	            ps.setString(2, emp.emp_name);
	            ps.setDouble(3, emp.emp_salary);
	            ps.executeUpdate();
	            System.out.println("\nEmployee inserted into emp table.");
	        } catch (SQLIntegrityConstraintViolationException e) {
	            System.out.println("\nEmployee ID already exists in the emp table.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 static void fetchFromEmpTable(String empId) {
	        System.out.println("\nFetching employee from emp table:");
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	            String sql = "SELECT * FROM emp WHERE emp_id = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, empId);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                System.out.println("ID: " + rs.getString("emp_id"));
	                System.out.println("Name: " + rs.getString("emp_name"));
	                System.out.println("Salary: " + rs.getDouble("emp_salary"));
	            } else {
	                System.out.println("No employee found with ID: " + empId);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }


	}

}

/*
Enter Employee ID: E001
Enter Employee Name: Alice
Enter Employee Salary: 7500

Employee serialized to emp.ser (salary excluded).

Deserialized Employee:
Employee ID: E001
Employee Name: Alice
Employee Salary: 0.0

Employee inserted into emp table.

Fetching employee from emp table:
ID: E001
Name: Alice
Salary: 7500.0
*/