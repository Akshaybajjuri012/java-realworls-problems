package jdbcdemo;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class GroupStudentsByDepartment {

    // DB config
    static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "Akshay@9100";

    // Student class
    static class Student {
        int id;
        String name;
        String department;

        public Student(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Fetch students from database
    public static List<Student> fetchStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT id, name, department FROM student";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> studentList = fetchStudents();

        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        // Grouping by department using Java 8 streams
        Map<String, List<Student>> groupedByDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        // Display results
        System.out.println("Students grouped by department:");
        for (Map.Entry<String, List<Student>> entry : groupedByDept.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (Student s : entry.getValue()) {
                System.out.println("  - " + s.getName());
            }
        }
    }
}

/*
Students grouped by department:
Department: EEE
  - David
Department: CSE
  - Alice
  - Charlie
Department: ECE
  - Bob
  - Eva
*/