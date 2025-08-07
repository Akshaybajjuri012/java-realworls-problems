package problem14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import problem14.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
