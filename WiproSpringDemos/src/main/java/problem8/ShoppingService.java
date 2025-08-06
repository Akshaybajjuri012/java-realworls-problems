package problem8;

public class ShoppingService {

    public void addToCart(String item) {
        System.out.println("Adding item to cart: " + item);
    }

    public void makePayment(double amount) {
        System.out.println("Making payment of amount: $" + amount);
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }
    }

    public void placeOrder() {
        System.out.println("Placing the order...");
    }
}
