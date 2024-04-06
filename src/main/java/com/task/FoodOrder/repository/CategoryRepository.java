package com.task.FoodOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.FoodOrder.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	long count();
}
