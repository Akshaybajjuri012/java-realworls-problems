package assignment;
import java.util.Scanner;
public class Problem9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        double totalRetailValue = 0.0;
        boolean Input = true;
        while (Input) {
            System.out.print("Enter prodnum(1-3) or 0 to finish: ");
            int productNumber = sc.nextInt();
            if (productNumber == 0) {
                break;  
            }
            System.out.print("Enter quantity sold: ");
            int quantity = sc.nextInt();
            double price = 0.0;        
            switch (productNumber) {
                case 1:
                    price = 22.50;
                    break;
                case 2:
                    price = 44.50;
                    break;
                case 3:
                    price = 9.98;
                    break;
                default:
                    System.out.println("Invalid product number. Please enter 1, 2, or 3.");
                    continue; 
            }
            double total = price * quantity;
            totalRetailValue += total;
            System.out.printf("Subtotal for product %d: $%.2f\n", productNumber, total);
        }
        System.out.printf("Total retail value of all products sold: $%.2f\n", totalRetailValue);
        

	}

}


/*
Enter prodnum(1-3) or 0 to finish: 1
Enter quantity sold: 6
Subtotal for product 1: $135.00
Enter prodnum(1-3) or 0 to finish: 2
Enter quantity sold: 4
Subtotal for product 2: $178.00
Enter prodnum(1-3) or 0 to finish: 3
Enter quantity sold: 2
Subtotal for product 3: $19.96
Enter prodnum(1-3) or 0 to finish: 0
Total retail value of all products sold: $332.96
*/