package com.task.FoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.City;


public interface AreaRepository extends JpaRepository<Area, Long> {
	List<Area> findByCity(City city);
	long count();
}
