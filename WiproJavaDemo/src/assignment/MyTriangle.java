package assignment;
import java.util.Scanner;
public class MyTriangle {
	public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double area(double a, double b, double c) {
        double s = perimeter(a, b, c) / 2;  
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    
    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter side a (-1 to exit): ");
            double a = scanner.nextDouble();

            if (a == -1) {
                System.out.println("Bye~");
                break;
            }

            System.out.print("Enter side b: ");
            double b = scanner.nextDouble();

            System.out.print("Enter side c: ");
            double c = scanner.nextDouble();

            if (!isValid(a, b, c)) {
                System.out.println("The input is invalid.");
                continue; 
            }
            double peri = perimeter(a, b, c);
            double ar = area(a, b, c);

            System.out.printf("Perimeter: %.2f\n", peri);
            System.out.printf("Area: %.2f\n", ar);
        }
		
		

	}

}

/*
Enter side a (-1 to exit): 5
Enter side b: 6
Enter side c: 2
Perimeter: 13.00
Area: 4.68
Enter side a (-1 to exit): -1
Bye~
*/