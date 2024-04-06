package com.task.FoodOrder.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.entity.SubCategory;
import com.task.FoodOrder.repository.CategoryRepository;
import com.task.FoodOrder.service.sub_category.SubCategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SubCategoryService subCategoryService;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public boolean saveCategory(Category category) {
		try {
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public boolean deleteCategory(Long id) {
		Category category = categoryRepository.findById(id).orElse(null);
        
        if (category != null) {
            for (SubCategory subCategory : subCategoryService.getSubCategoryByCategory(category)) {
            	subCategoryService.deleteSubCategory(subCategory.getId());
            }
            
            categoryRepository.delete(category);
            
            return true;
        }
        
        return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        try {
            existingCategory.setName(category.getName());
            existingCategory.setDescription(category.getDescription());
            List<SubCategory> subCategories = subCategoryService.getSubCategoryByCategory(existingCategory);
            for (SubCategory subCategory : subCategories) {
            	subCategory.setCategory(existingCategory);
                subCategoryService.saveSubCategory(subCategory);
            }
            categoryRepository.save(existingCategory);
            return true;
        }
        catch (Exception e) {
        	return false;
		}
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return categoryRepository.count();
	}

}
