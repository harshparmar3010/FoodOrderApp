package com.task.FoodOrder.service.sub_category;

import java.util.List;

import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.SubCategory;

public interface SubCategoryService {
	public List<SubCategory> getAllSubCategories();

    public SubCategory getSubCategoryById(Long id);

    public boolean saveSubCategory(SubCategory subCategory);

    public boolean deleteSubCategory(Long id);

    public boolean updateSubCategory(SubCategory subCategory);
    
    public List<SubCategory> getSubCategoryByCategory(Category category);
    
    long getCount();
}
