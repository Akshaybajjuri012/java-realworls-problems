package com.wipro.restaurentexample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class RestaurantController {
	@GetMapping("/restaurants")
    public List<Map<String, String>> getRestaurants() {
        return Arrays.asList(
                Map.of("id", "1", "name", "Pasta Palace", "location", "Rome"),
                Map.of("id", "2", "name", "Sushi Central", "location", "Tokyo"),
                Map.of("id", "3", "name", "Burger Town", "location", "New York")
        );
    }

}
