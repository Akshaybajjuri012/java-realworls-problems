package assignment;
import java.util.Scanner;
public class Problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name:");
		String name=sc.nextLine();
		System.out.println("Enter your Roll Num:");
		String rollno=sc.nextLine();
		System.out.println("Enter your Field of Interest:");
		String foi=sc.nextLine();
		System.out.println("Hey, my name is " + name + " and my roll number is " + rollno + 
                ". My field of interest are " + foi + ".");
		

	}

}

/*
Enter your Name:
akshay
Enter your Roll Num:
465
Enter your Field of Interest:
ece
Hey, my name is akshay and my roll number is 465. My field of interest are ece.
*/