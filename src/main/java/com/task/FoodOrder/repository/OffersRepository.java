package com.task.FoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.FoodOrder.entity.Offers;
import com.task.FoodOrder.entity.Restaurant;

public interface OffersRepository extends JpaRepository<Offers, Long>{
	List<Offers> findByRestaurant(Restaurant restaurant);
	long count();
	long countByRestaurantId(Long restaurantId);
}
