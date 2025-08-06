package problem9;

public class ProductItem {
    private int productId;
    private String productName;
    private double price;

    public ProductItem(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "ProductItem [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
    }
}
