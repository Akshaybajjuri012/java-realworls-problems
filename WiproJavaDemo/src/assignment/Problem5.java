package assignment;
import java.util.Scanner;
public class Problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your salary: ");
	    double salary = sc.nextDouble();  
	    System.out.print("Enter your years of service: ");
	    int yearsOfService = sc.nextInt();
	    if (yearsOfService > 6) {
	        double bonus = salary * 0.10;
	        System.out.println("Your bonus amount is: " + bonus);
	    } else {	    	
	        System.out.println("You are not eligible for the bonus.");
	    }

	}

}


/*
Enter your salary: 20000
Enter your years of service: 1
You are not eligible for the bonus.


Enter your salary: 20000
Enter your years of service: 7
Your bonus amount is: 2000.0



*/