package com.task.FoodOrder.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.SubCategory;
import com.task.FoodOrder.service.category.CategoryService;
import com.task.FoodOrder.service.sub_category.SubCategoryService;
import com.task.FoodOrder.validation.MainValidation;

@Controller
@RequestMapping("/admin/sub_category")
public class SubCategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@GetMapping({"/",""})
	String manageSubCategoryPage(Model model)
	{
		model.addAttribute("sub_categories", subCategoryService.getAllSubCategories());
		return "admin/sub_category/main";
	}
	
	@GetMapping("/add")
	String addSubCategoryPage(Model model) {
		model.addAttribute("action","add");
		model.addAttribute("categories", categoryService.getAllCategories());
		return "admin/sub_category/add_sub_category";
	}
	
	@PostMapping("/add")
	String addSubCategory(
			@RequestParam Long category_id,
			@RequestParam String name,
			@RequestParam String description
			)
	{
		Category category = categoryService.getCategoryById(category_id);
		if(category==null) {
			return "";
		}
		SubCategory subCategory = new SubCategory(category,name,description);
		if(MainValidation.validateSubCategory(subCategory))
		{
			if(subCategoryService.saveSubCategory(subCategory))
			{
				return "redirect:/admin/sub_category";
			}
		}
		return "";
	}
	
	@GetMapping("/edit")
	String editSubCategoryPage(@RequestParam Long id,Model model) {
		SubCategory subCategory = subCategoryService.getSubCategoryById(id);
		
		if(subCategory==null)
		{
			return "";
		}
		
		model.addAttribute("action","edit");
		model.addAttribute("sub_category", subCategory);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "admin/sub_category/add_sub_category";
	}
	
	@PostMapping("/edit")
	String addSubCategory(
			@RequestParam Long id,
			@RequestParam Long category_id,
			@RequestParam String name,
			@RequestParam String description
			)
	{
		Category category = categoryService.getCategoryById(category_id);
		if(category==null) {
			return "";
		}
		SubCategory subCategory = new SubCategory(id,category,name,description);
		if(MainValidation.validateSubCategory(subCategory))
		{
			if(subCategoryService.updateSubCategory(subCategory))
			{
				return "redirect:/admin/sub_category";
			}
		}
		
		return "";
	}
	
	@GetMapping("/delete")
	String deleteSubCategory(@RequestParam Long id)
	{
		if(subCategoryService.deleteSubCategory(id))
		{
			return "redirect:/admin/sub_category";
		}
		return "";
	}
	
	


}
