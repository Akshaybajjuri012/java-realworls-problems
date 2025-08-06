package problem9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PurchaseApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PurchaseOrder purchase = (PurchaseOrder) context.getBean("purchaseOrderBean");
        purchase.displayDetails();
    }
}
