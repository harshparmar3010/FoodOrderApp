package com.task.FoodOrder.service.sub_category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.SubCategory;
import com.task.FoodOrder.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	SubCategoryRepository subCategoryRepository;

	@Override
	public List<SubCategory> getAllSubCategories() {
		// TODO Auto-generated method stub
		return subCategoryRepository.findAll();
	}

	@Override
	public SubCategory getSubCategoryById(Long id) {
		// TODO Auto-generated method stub
		return subCategoryRepository.findById(id).orElse(null);
	}

	@Override
	public boolean saveSubCategory(SubCategory subCategory) {
		try {
            subCategoryRepository.save(subCategory);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public boolean deleteSubCategory(Long id) {
		subCategoryRepository.deleteById(id);
        if(!subCategoryRepository.existsById(id))
        	return true;
        return false;
	}

	@Override
	public boolean updateSubCategory(SubCategory subCategory) {
		try {
            if (subCategoryRepository.existsById(subCategory.getId())) {
            	subCategoryRepository.save(subCategory);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public List<SubCategory> getSubCategoryByCategory(Category category) {
		// TODO Auto-generated method stub
		return subCategoryRepository.findByCategory(category);
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return subCategoryRepository.count();
	}
}
