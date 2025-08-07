package problem14.service;

import org.springframework.stereotype.Service;
import problem14.exception.ResourceNotFoundException;
import problem14.model.Food;
import problem14.model.Restaurant;
import problem14.repository.FoodRepository;
import problem14.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, FoodRepository foodRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + id));
    }

    public void deleteRestaurant(Long id) {
        Restaurant restaurant = getRestaurantById(id);
        restaurantRepository.delete(restaurant);
    }

    public Food addFoodToRestaurant(Long restaurantId, Food food) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        food.setRestaurant(restaurant);
        return foodRepository.save(food);
    }

    public void deleteFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + foodId));
        foodRepository.delete(food);
    }
}
