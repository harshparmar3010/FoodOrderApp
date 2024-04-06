package com.task.FoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
	List<SubCategory> findByCategory(Category category);
	long count();
}
