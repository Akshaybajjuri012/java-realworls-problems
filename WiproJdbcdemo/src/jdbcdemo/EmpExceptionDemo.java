package jdbcdemo;
import java.sql.*;
import java.util.Scanner;
@SuppressWarnings("serial")
class InvalidEmployeeCodeException extends Exception {
    public InvalidEmployeeCodeException(String message) {
        super(message);
    }
}
public class EmpExceptionDemo {
	 public static void validateEmployeeCode(String empCode) throws InvalidEmployeeCodeException {
	        if (!empCode.matches("EMP\\d{3}")) {
	            throw new InvalidEmployeeCodeException("Invalid Employee Code: " + empCode);
	        }
	    }
	 @SuppressWarnings("resource")

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        String dbUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "company";
        String user = "root";     
        String pass = "Akshay@9100";
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL server (no DB yet)
            try (Connection conn = DriverManager.getConnection(dbUrl, user, pass);
                 Statement stmt = conn.createStatement()) {

                // Create database if it doesn't exist
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
                System.out.println("Database 'company' is ready.");
            }
            try (Connection conn = DriverManager.getConnection(dbUrl + dbName, user, pass);
                    Statement stmt = conn.createStatement()) {

                   // Create table if it doesn't exist
                   String createTableSQL = """
                       CREATE TABLE IF NOT EXISTS employee_records (
                           emp_code VARCHAR(10) PRIMARY KEY,
                           name VARCHAR(100),
                           department VARCHAR(100)
                       );
                       """;
                   stmt.executeUpdate(createTableSQL);
                   System.out.println("Table 'employee_records' is ready.");

                   // Input employee data
                   System.out.print("\nEnter Employee Code (e.g. EMP123): ");
                   String empCode = sc.nextLine();
                   validateEmployeeCode(empCode);

                   System.out.print("Enter Employee Name: ");
                   String name = sc.nextLine();

                   System.out.print("Enter Department: ");
                   String dept = sc.nextLine();
                   // Insert employee
                   String insertSQL = "INSERT INTO employee_records (emp_code, name, department) VALUES (?, ?, ?)";
                   try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                       pstmt.setString(1, empCode);
                       pstmt.setString(2, name);
                       pstmt.setString(3, dept);
                       pstmt.executeUpdate();
                       System.out.println("✅ Employee inserted successfully.");
                   }
                   // Display employee
                   String selectSQL = "SELECT * FROM employee_records WHERE emp_code = ?";
                   try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                       pstmt.setString(1, empCode);
                       ResultSet rs = pstmt.executeQuery();
                       if (rs.next()) {
                           System.out.println("\nEmployee Details:");
                           System.out.println("Code      : " + rs.getString("emp_code"));
                           System.out.println("Name      : " + rs.getString("name"));
                           System.out.println("Department: " + rs.getString("department"));
                       }
                   }
               }
        } catch (InvalidEmployeeCodeException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ Error: Employee with this code already exists.");
        } catch (SQLException e) {
            System.out.println("❌ SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found.");
        }

	}

}

/*
Database 'company' is ready.
Table 'employee_records' is ready.

Enter Employee Code (e.g. EMP123): EMP101
Enter Employee Name: Akshay
Enter Department: it
✅ Employee inserted successfully.

Employee Details:
Code      : EMP101
Name      : Akshay
Department: it
*/