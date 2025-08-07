package consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class RestaurantConsumerController {

    private final RestaurantClient restaurantClient;

    public RestaurantConsumerController(RestaurantClient restaurantClient) {
        this.restaurantClient = restaurantClient;
    }

    @GetMapping("/consumer/restaurants")
    public List<Map<String, String>> getConsumerRestaurants() {
        return restaurantClient.getRestaurants();
    }
}
