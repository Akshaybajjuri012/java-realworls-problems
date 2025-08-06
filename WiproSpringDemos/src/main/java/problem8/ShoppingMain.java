package problem8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShoppingMain {

    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        ShoppingService shoppingService = context.getBean("shoppingService", ShoppingService.class);

        shoppingService.addToCart("Laptop");
        try {
            shoppingService.makePayment(1000);
            shoppingService.makePayment(-5); // This will throw exception
        } catch (Exception e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }
        shoppingService.placeOrder();

        context.close();
    }
}
