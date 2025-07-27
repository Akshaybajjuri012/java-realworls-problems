package assignment;
public class Calculator {
    void add(double a, double b) {
        System.out.println("Addition: " + (a + b));
    }
    void diff(double a, double b) {
        System.out.println("Difference: " + (a - b));
    }
    void mul(double a, double b) {
        System.out.println("Multiplication: " + (a * b));
    }  
    void div(double a, double b) {       
        System.out.println("Division: " + (a / b));
    }



	public static void main(String[] args) {
		Calculator calc = new Calculator();
        double num1 = 20;
        double num2 = 5;
        calc.add(num1, num2);
        calc.diff(num1, num2);
        calc.mul(num1, num2);
        calc.div(num1, num2);

	}

}

/*
Addition: 25.0
Difference: 15.0
Multiplication: 100.0
Division: 4.0
*/