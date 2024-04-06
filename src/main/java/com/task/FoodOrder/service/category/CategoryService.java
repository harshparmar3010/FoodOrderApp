package com.task.FoodOrder.service.category;

import java.util.List;

import com.task.FoodOrder.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategories();

    public Category getCategoryById(Long id);

    public boolean saveCategory(Category category);

    public boolean deleteCategory(Long id);

    public boolean updateCategory(Category category);
    
    long getCount();
}
