package assignment;
import java.util.Scanner;
public class Problem7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of classes held: ");
        int classesHeld = sc.nextInt();
        System.out.print("Enter the number of classes attended: ");
        int classesAttended = sc.nextInt();
        if (classesHeld <= 0) {
            System.out.println("Invalid input. Number of classes held must be greater than 0.");
        } else if (classesAttended > classesHeld || classesAttended < 0) {
            System.out.println("Invalid input. Attended classes can't be more than held or less than 0.");
        } else {
            double attendancePercentage = (classesAttended * 100.0) / classesHeld;
            System.out.println("Attendance Percentage:"+ attendancePercentage);
            if (attendancePercentage >= 70) {
                System.out.println("You are allowed to sit in the exam.");
            } else {
                System.out.println("You are NOT allowed to sit in the exam.");
            }
        }


	}

}

/*
Enter the number of classes held: 100
Enter the number of classes attended: 75
Attendance Percentage:75.0
You are allowed to sit in the exam.
*/
