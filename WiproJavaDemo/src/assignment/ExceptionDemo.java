package assignment;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		 try {
	            System.out.print("Enter an integer: ");
	            int number = scanner.nextInt();  
	            System.out.println("You entered: " + number);
	        } catch (InputMismatchException e) {
	            System.out.println("Caught InputMismatchException: Please enter a valid integer.");
	            scanner.nextLine(); 
	        }
		 scanner.nextLine();
		 try {
	            System.out.print("Enter a string: ");
	            String input = scanner.nextLine();
	            System.out.print("Enter an index to access character: ");
	            int index = scanner.nextInt();
	            char ch = input.charAt(index); 
	            System.out.println("Character at index " + index + " is: " + ch);
	        } catch (StringIndexOutOfBoundsException e) {
	            System.out.println("Caught StringIndexOutOfBoundsException: Index is out of range.");
	        }

	}

}


/*
Enter an integer: 23
You entered: 23
Enter a string: hello
Enter an index to access character: 1
Character at index 1 is: e
*/