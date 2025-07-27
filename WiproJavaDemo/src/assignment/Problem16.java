package assignment;
import java.util.Scanner;
public class Problem16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] marks=new int[3];
		for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter the mark (0-100) for student " + (i + 1) + ": ");
                if (sc.hasNextInt()) {
                    int mark = sc.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;  
                    } else {
                        System.out.println("Invalid input, try again...");
                    }
                } else {                   
                    System.out.println("Invalid input, try again...");
                    sc.next(); 
                }
            }
        }
		int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        double average = (double) sum / marks.length;
        System.out.printf("The average is: %.2f\n", average);

	}

}

/*
Enter the mark (0-100) for student 1: 80
Enter the mark (0-100) for student 2: 60
Enter the mark (0-100) for student 3: 59
The average is: 66.33
*/