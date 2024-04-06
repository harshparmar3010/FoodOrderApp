package com.task.FoodOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.FoodOrder.entity.Restaurant;
import java.util.List;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	Restaurant findByEmail(String email);
	long count();
	
	boolean existsByEmail(String email);
	
	boolean existsByContactNo(Long contactNo);
}
