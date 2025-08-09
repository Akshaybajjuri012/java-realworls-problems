package problem7;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class BillingApp {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService service = (ProductService) context.getBean("productService");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Generate Bill by entering code and quantity");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            switch (choice) {
            case 1:
                int productCode = 0;
                while (true) {
                    System.out.print("Enter product_code: ");
                    productCode = sc.nextInt();
                    if (service.validateProductCode(productCode)) break;
                    else System.out.println("Invalid product_code, it should be >0 and 4 digit +ve number");
                }

                int quantity = 0;
                while (true) {
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    if (service.validateQuantity(quantity)) break;
                    else System.out.println("Invalid quantity, it should be >0");
                }
                try {
                    Product p = service.getProductDetails(productCode);
                    double total = service.calculatePrice(quantity, p.getProduct_price());
                    System.out.println("Product Name: " + p.getProduct_name());
                    System.out.println("Product Category: " + p.getProduct_category());
                    System.out.println("Product Description: " + p.getProduct_description());
                    System.out.println("Product Price(Rs): " + p.getProduct_price());
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Total Bill Amount: Rs." + total);
                } catch (Exception e) {
                    System.out.println("Product not found for code: " + productCode);
                }
                break;

            case 2:
                System.exit(0);
                break;

            default:
                System.out.println("Enter option 1 to 2 only");
        }
        }
    }

}
