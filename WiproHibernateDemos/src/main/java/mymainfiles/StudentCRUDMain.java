package mymainfiles;
import java.util.List;
import java.util.Scanner;

import mydaofiles.StudentDao;
import mypojos.student_123;
public class StudentCRUDMain {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add  2. View  3. Update  4. Delete  5. View All ");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    student_123 s1 = new student_123();
                    // System.out.print("Enter ID: ");//NO NEED! BCOS IT IS AUTOINCREMENT FIELD
                    //s1.setId(sc.nextInt());
                    System.out.print("Enter Name: ");
                    s1.setName(sc.next());
                    System.out.print("Enter Email: ");
                    s1.setEmail(sc.next());
                    dao.addStudent(s1);     //INSERT OBJECT INTO MYSQL TABLE      
                    break;
                case 2:
                    System.out.print("Enter ID to view: ");
                    student_123 s2 = dao.getstudent(sc.nextInt());
                    if (s2 != null) {
                        System.out.println("Name: " + s2.getName() + ", Email: " + s2.getEmail());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    student_123 s3 = new student_123();
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    s3.setName(sc.next());
                    System.out.print("Enter New Email: ");
                    s3.setEmail(sc.next());
                    s3.setId(upId);
                    boolean updated = dao.updatestudent(s3);
                    if (updated) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student with ID " + upId + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    boolean deleted = dao.deletestudent(delId);
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student with ID " + delId + " not found.");
                    }
                    break;
                case 5:
                    List<student_123> list = dao.getAllstudents();
                    for (student_123 s : list) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
                    }
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                    
            }
        }

	}


}
