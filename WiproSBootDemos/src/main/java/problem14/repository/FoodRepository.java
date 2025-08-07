package problem14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import problem14.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
