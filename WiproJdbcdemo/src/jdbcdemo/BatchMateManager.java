package jdbcdemo;
import java.io.*;
import java.sql.*;
import java.util.*;
public class BatchMateManager {
	static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "Akshay@9100";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String fileName = "batchmates.txt";
	        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");

	        // Step 1: Write to File
	        writeNamesToFile(fileName, names);

	        // Step 2: Read from File and Display
	        readNamesFromFile(fileName);

	        // Step 3: Connect to SQL and insert names
	        insertNamesIntoDatabase(names);
	        displayNamesFromDatabase();
    }
	 static void writeNamesToFile(String fileName, List<String> names) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            for (String name : names) {
	                writer.write(name);
	                writer.newLine();
	            }
	            System.out.println("Names written to file successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 static void readNamesFromFile(String fileName) {
	        System.out.println("\nContents of " + fileName + ":");
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println("- " + line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 static void insertNamesIntoDatabase(List<String> names) {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	            String insertSQL = "INSERT INTO batchmates (name) VALUES (?)";
	            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

	            for (String name : names) {
	                pstmt.setString(1, name);
	                pstmt.executeUpdate();
	            }

	            System.out.println("\nNames inserted into database successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 static void displayNamesFromDatabase() {
	        System.out.println("\nBatchmates from database:");
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             Statement stmt = conn.createStatement()) {

	            ResultSet rs = stmt.executeQuery("SELECT id, name FROM batchmates");

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                System.out.println(id + ": " + name);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	}

}
