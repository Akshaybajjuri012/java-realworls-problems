package assignment;
import java.util.*;

public class StudentStandard {

    static class Student {
        private static int rollCounter = 1;
        private int rollNo;
        private String studName;
        private int marksInEng;
        private int marksInMaths;
        private int marksInScience;

        public Student(String studName, int marksInEng, int marksInMaths, int marksInScience) {
            this.rollNo = rollCounter++;
            this.studName = studName;
            this.marksInEng = marksInEng;
            this.marksInMaths = marksInMaths;
            this.marksInScience = marksInScience;
        }

        
        public int getRollNo() { 
        	return rollNo; 
        	}
        public String getStudName() { 
        	return studName; 
        	}
        public int getMarksInEng() { 
        	return marksInEng; 
        	}
        public int getMarksInMaths() { 
        	return marksInMaths; 
        	}
        public int getMarksInScience() { 
        	return marksInScience; 
        	}

       
        public void setStudName(String studName) { 
        	this.studName = studName;
        	}
        public void setMarksInEng(int marksInEng) {
        	this.marksInEng = marksInEng; 
        	}
        public void setMarksInMaths(int marksInMaths) { 
        	this.marksInMaths = marksInMaths; 
        	}
        public void setMarksInScience(int marksInScience) {
        	this.marksInScience = marksInScience; 
        	}

        public int getTotalMarks() {
            return marksInEng + marksInMaths + marksInScience;
        }

        public double getPercentage() {
            return getTotalMarks() / 3.0;
        }
    }

 
    static class Standard {
        private List<Student> students;

        public Standard() {
            students = new ArrayList<>();

          
            students.add(new Student("Alice", 85, 90, 80));
            students.add(new Student("Bob", 75, 95, 85));
            students.add(new Student("Charlie", 70, 88, 78));
            students.add(new Student("David", 90, 92, 93));
            students.add(new Student("Eva", 88, 85, 90));
            students.add(new Student("Frank", 60, 70, 65));
            students.add(new Student("Grace", 92, 94, 91));
            students.add(new Student("Helen", 78, 89, 84));
        }

        
        public void displayStudentsByRollNo() {
            System.out.println("Students in ascending order of Roll No:");
            students.stream()
                    .sorted(Comparator.comparingInt(Student::getRollNo))
                    .forEach(s -> System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()));
        }

        
        public void displayTopperByPercentage() {
            Student topStudent = Collections.max(students, Comparator.comparingDouble(Student::getPercentage));
            System.out.println("Topper (Highest Percentage): Roll No: " + topStudent.getRollNo() +
                    ", Name: " + topStudent.getStudName());
        }

        
        public void displayTopperInMaths() {
            Student topMathStudent = Collections.max(students, Comparator.comparingInt(Student::getMarksInMaths));
            System.out.println("Topper in Maths: Roll No: " + topMathStudent.getRollNo() +
                    ", Name: " + topMathStudent.getStudName());
        }

       
        public void displayByMathsAndScienceMarks() {
            System.out.println("Students sorted by total marks in Maths and Science:");
            students.stream()
                    .sorted(Comparator.comparingInt(s -> s.getMarksInMaths() + s.getMarksInScience()))
                    .forEach(s -> {
                        int total = s.getMarksInMaths() + s.getMarksInScience();
                        System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName() +
                                ", Maths+Science: " + total);
                    });
        }

        
        public void displayAllWithRank() {
            List<Student> rankedList = new ArrayList<>(students);
            rankedList.sort(Comparator.comparingDouble(Student::getPercentage).reversed());

            int rank = 1;
            System.out.println("All students with rank:");
            for (Student s : rankedList) {
                System.out.printf("Rank %d: Roll No: %d, Name: %s, Total: %d, Percentage: %.2f%%\n",
                        rank++, s.getRollNo(), s.getStudName(), s.getTotalMarks(), s.getPercentage());
            }
        }
    }

 
    public static void main(String[] args) {
        Standard std = new Standard();

        System.out.println("\n--- Students by Roll No ---");
        std.displayStudentsByRollNo();

        System.out.println("\n--- Topper by Percentage ---");
        std.displayTopperByPercentage();

        System.out.println("\n--- Topper in Mathematics ---");
        std.displayTopperInMaths();

        System.out.println("\n--- Students by Maths + Science Marks ---");
        std.displayByMathsAndScienceMarks();

        System.out.println("\n--- Students with Rank ---");
        std.displayAllWithRank();
    }
}


/*

--- Students by Roll No ---
Students in ascending order of Roll No:
Roll No: 1, Name: Alice
Roll No: 2, Name: Bob
Roll No: 3, Name: Charlie
Roll No: 4, Name: David
Roll No: 5, Name: Eva
Roll No: 6, Name: Frank
Roll No: 7, Name: Grace
Roll No: 8, Name: Helen

--- Topper by Percentage ---
Topper (Highest Percentage): Roll No: 7, Name: Grace

--- Topper in Mathematics ---
Topper in Maths: Roll No: 2, Name: Bob

--- Students by Maths + Science Marks ---
Students sorted by total marks in Maths and Science:
Roll No: 6, Name: Frank, Maths+Science: 135
Roll No: 3, Name: Charlie, Maths+Science: 166
Roll No: 1, Name: Alice, Maths+Science: 170
Roll No: 8, Name: Helen, Maths+Science: 173
Roll No: 5, Name: Eva, Maths+Science: 175
Roll No: 2, Name: Bob, Maths+Science: 180
Roll No: 4, Name: David, Maths+Science: 185
Roll No: 7, Name: Grace, Maths+Science: 185

--- Students with Rank ---
All students with rank:
Rank 1: Roll No: 7, Name: Grace, Total: 277, Percentage: 92.33%
Rank 2: Roll No: 4, Name: David, Total: 275, Percentage: 91.67%
Rank 3: Roll No: 5, Name: Eva, Total: 263, Percentage: 87.67%
Rank 4: Roll No: 1, Name: Alice, Total: 255, Percentage: 85.00%
Rank 5: Roll No: 2, Name: Bob, Total: 255, Percentage: 85.00%
Rank 6: Roll No: 8, Name: Helen, Total: 251, Percentage: 83.67%
Rank 7: Roll No: 3, Name: Charlie, Total: 236, Percentage: 78.67%
Rank 8: Roll No: 6, Name: Frank, Total: 195, Percentage: 65.00%
*/