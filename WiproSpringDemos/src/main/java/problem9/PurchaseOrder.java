package problem9;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseOrder {
    private int purchaseId;
    private Date purchaseDate;
    private ProductItem product;

    public PurchaseOrder(int purchaseId, String purchaseDateStr, ProductItem product) {
        this.purchaseId = purchaseId;
        try {
            this.purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(purchaseDateStr);
        } catch (Exception e) {
            e.printStackTrace();
            this.purchaseDate = new Date();
        }
        this.product = product;
    }

    public void displayDetails() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Product Details: " + product);
    }
}
