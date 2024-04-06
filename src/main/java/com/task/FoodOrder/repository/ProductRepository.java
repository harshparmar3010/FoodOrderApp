package com.task.FoodOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.FoodOrder.entity.Product;
import java.util.List;
import com.task.FoodOrder.entity.Restaurant;


public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByRestaurant(Restaurant restaurant);
	long count();
	long countByRestaurantId(Long restaurantId);
}
