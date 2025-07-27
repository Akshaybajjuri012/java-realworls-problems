package assignment;
import java.util.Scanner;
public class Problem8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of classes held: ");
        int classesHeld = sc.nextInt();
        System.out.print("Enter the number of classes attended: ");
        int classesAttended = sc.nextInt();
        System.out.print("Do you have a medical cause? (Y/N): ");
        char medicalCause = sc.next().charAt(0);
        if (classesHeld <= 0) {
            System.out.println("Invalid input. Number of classes held must be greater than 0.");
        } else if (classesAttended > classesHeld || classesAttended < 0) {
            System.out.println("Invalid input. Attended classes can't be more than held or less than 0.");
        } else {
            double attendancePercentage = (classesAttended * 100.0) / classesHeld;
            System.out.println("Attendance Percentage:"+ attendancePercentage);
            if (attendancePercentage >= 70) {
                System.out.println("You are allowed to sit in the exam.");
            } else if (medicalCause == 'Y') {
                System.out.println("You are allowed to sit in the exam due to medical cause.");
            
            } else {
                System.out.println("You are NOT allowed to sit in the exam.");
            }
        }

	}

}


/*
Enter the number of classes held: 80
Enter the number of classes attended: 40
Do you have a medical cause? (Y/N): n
Attendance Percentage:50.0
You are NOT allowed to sit in the exam.
*/