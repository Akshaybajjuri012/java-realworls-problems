package grocery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {
	@GetMapping("/grocery/public")
    public String publicMessage() {
        return "Welcome to the Grocery Store!";
    }

    @GetMapping("/grocery/items")
    public String groceryItems() {
        return "List of grocery items: Milk, Bread, Eggs.";
    }

    @GetMapping("/grocery/orders")
    public String groceryOrders() {
        return "List of grocery orders: Order#1, Order#2.";
    }

    @GetMapping("/grocery/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "Hello Admin! This is a protected admin endpoint.";
    }

}
