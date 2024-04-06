package com.task.FoodOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.task.FoodOrder.entity.City;


public interface CityRepository extends JpaRepository<City, Long> {
	long count();
}
