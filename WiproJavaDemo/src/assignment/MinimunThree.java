package assignment;
import java.util.Scanner;
import java.util.function.BiFunction;

@FunctionalInterface
interface MinFunction {
    double minimum3(double a, double b, double c);
}
public class MinimunThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	     System.out.print("Enter first number: ");
	     double x = scanner.nextDouble();
	     System.out.print("Enter second number: ");
	     double y = scanner.nextDouble();
	     System.out.print("Enter third number: ");
	     double z = scanner.nextDouble();
	     BiFunction<Double, Double, Double> minTwo = Math::min;
	     MinFunction minThree = (a, b, c) -> minTwo.apply(minTwo.apply(a, b), c);
	     double result = minThree.minimum3(x, y, z);
	     System.out.println("The smallest value is: " + result);

	}

}

/*
Enter first number: 23
Enter second number: 15
Enter third number: 25
The smallest value is: 15.0
*/