package jdbcdemo;
import java.sql.*;
public class EmployeeDemo {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "Akshay@9100";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {

               String createTable = "CREATE TABLE IF NOT EXISTS employee (" +
                       "employeeId VARCHAR(10) PRIMARY KEY," +
                       "name VARCHAR(100)," +
                       "yearOfBirth INT)";
               stmt.executeUpdate(createTable);

               
               stmt.executeUpdate("INSERT IGNORE INTO employee VALUES ('81-M-112', 'Akshay', 1985)");
               stmt.executeUpdate("INSERT IGNORE INTO employee VALUES ('79-M-254', 'Neha', 1982)");
               ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

               while (rs.next()) {
                   String empId = rs.getString("employeeId");
                   String name = rs.getString("name");
                   int yob = rs.getInt("yearOfBirth");

                   String[] parts = empId.split("-");
                   if (parts.length == 3) {
                       String joinYear = "19" + parts[0];
                       String designation = parts[1].equalsIgnoreCase("F") ? "Faculty"
                                          : parts[1].equalsIgnoreCase("S") ? "Staff"
                                          : "Unknown";
                       String empNum = parts[2];
                       System.out.println("\n📋 Employee Info:");
                       System.out.println("ID           : " + empId);
                       System.out.println("Name         : " + name);
                       System.out.println("Year of Birth: " + yob);
                       System.out.println("Joined Year  : " + joinYear);
                       System.out.println("Designation  : " + designation);
                       System.out.println("Emp Number   : " + empNum);
                   } else {
                       System.out.println("⚠️ Invalid ID format: " + empId);
                   }
               }

           } catch (SQLException e) {
               System.out.println("❌ SQL Error: " + e.getMessage());
           }
       }


}

/*

📋 Employee Info:
ID           : 79-M-254
Name         : Neha
Year of Birth: 1982
Joined Year  : 1979
Designation  : Staff
Emp Number   : 254

📋 Employee Info:
ID           : 81-M-112
Name         : Akshay
Year of Birth: 1985
Joined Year  : 1981
Designation  : Faculty
Emp Number   : 112
*/