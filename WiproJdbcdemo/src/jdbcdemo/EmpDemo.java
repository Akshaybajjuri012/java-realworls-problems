package jdbcdemo;
import java.sql.*;
public class EmpDemo {
	 static class LowSalException extends Exception {
	        public LowSalException(String message) {
	            super(message);
	        }
	 }
	 static class Emp {
	        private int empId;
	        private String empName;
	        private String designation;
	        private double basic;
	        private double hra;

	        public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
	            if (basic < 50000) {
	                throw new LowSalException("❌ Basic salary is below 50000 for employee: " + empName);
	            }
	            this.empId = empId;
	            this.empName = empName;
	            this.designation = designation;
	            this.basic = basic;

	            calculateHRA();
	        }
	        private void calculateHRA() {
	            switch (designation.toLowerCase()) {
	                case "manager":
	                    hra = basic * 0.10;
	                    break;
	                case "teamleader":
	                    hra = basic * 0.12;
	                    break;
	                case "hr":
	                    hra = basic * 0.05;
	                    break;
	                default:
	                    hra = 0.0;
	            }
	        }
	        public void printDET() {
	            System.out.println("\n📋 Employee Details:");
	            System.out.println("ID          : " + empId);
	            System.out.println("Name        : " + empName);
	            System.out.println("Designation : " + designation);
	            System.out.println("Basic       : ₹" + basic);
	            System.out.println("HRA         : ₹" + hra);
	        }
	    }
	 public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/mydb";
	        String user = "root";
	        String password = "Akshay@9100";
	        try (
	                Connection conn = DriverManager.getConnection(url, user, password);
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery("SELECT * FROM users");
	            ) {
	                while (rs.next()) {
	                    int id = rs.getInt("empId");
	                    String name = rs.getString("empName");
	                    String designation = rs.getString("designation");
	                    double basic = rs.getDouble("basic");
	                    try {
	                        Emp emp = new Emp(id, name, designation, basic);
	                        emp.printDET();
	                    } catch (LowSalException e) {
	                        System.out.println(e.getMessage());
	                    }
	                }

	            } catch (SQLException e) {
	                System.out.println("❌ Database error: " + e.getMessage());
	            }
	        }
	        

}
	 

/*
 
📋 Employee Details:
ID          : 101
Name        : Akshay
Designation : Manager
Basic       : ₹60000.0
HRA         : ₹6000.0

📋 Employee Details:
ID          : 102
Name        : Neha
Designation : TeamLeader
Basic       : ₹55000.0
HRA         : ₹6600.0
❌ Basic salary is below 50000 for employee: Ravi
*/
