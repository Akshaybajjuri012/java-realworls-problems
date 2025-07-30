package jdbcdemo;

import java.sql.*;
import java.util.*;

public class EmployeeSortUsingSQL {

    // Database configuration
    static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "Akshay@9100";

    // Employee class
    static class Employee {
        String id;
        String name;
        double salary;

        public Employee(String id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
        }
    }

    // Comparator to sort by salary descending
    static class SalaryDescComparator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e2.getSalary(), e1.getSalary());
        }
    }

    // Fetch data from 'emp' table
    public static List<Employee> getEmployeesFromDB() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT emp_id, emp_name, emp_salary FROM emp";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String id = rs.getString("emp_id");
                String name = rs.getString("emp_name");
                double salary = rs.getDouble("emp_salary");
                list.add(new Employee(id, name, salary));
            }

        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployeesFromDB();

        if (employees.isEmpty()) {
            System.out.println("No employees found in the database.");
            return;
        }

        // Sort by salary (descending)
        employees.sort(new SalaryDescComparator());
        System.out.println("\nSorted by Salary (Descending):");
        employees.forEach(System.out::println);

        // Sort by name (alphabetical)
        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        System.out.println("\nSorted by Name (Alphabetically):");
        employees.forEach(System.out::println);
    }
}

/*

Sorted by Salary (Descending):
Employee [ID=E001, Name=Alice, Salary=7500.0]

Sorted by Name (Alphabetically):
Employee [ID=E001, Name=Alice, Salary=7500.0]
*/