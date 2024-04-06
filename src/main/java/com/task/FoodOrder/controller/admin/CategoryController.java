package com.task.FoodOrder.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.service.category.CategoryService;
import com.task.FoodOrder.validation.MainValidation;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping({"/",""})
	
	String manageCategoryPage(Model model) {
		
		model.addAttribute("categories", categoryService.getAllCategories());
		return "admin/category/main";
	}
	
	@GetMapping("/add")
	String addCategoryPage(Model model) {
		model.addAttribute("action", "add");
		return "admin/category/add_category";
	}
	
	@PostMapping("/add")
	String addCategory(@ModelAttribute Category category)
	{
		if(MainValidation.validateCategory(category))
		{
			if(categoryService.saveCategory(category))
				return "redirect:/admin/category";
		}
		
		return "";
	}
	
	@GetMapping("/edit")
	String editCategoryPage(@RequestParam Long id, Model model)
	{
		Category category = categoryService.getCategoryById(id);
		
		if(category==null)
		{
			return "";
		}
		model.addAttribute("action","edit");
		model.addAttribute("category",category);
		return "admin/category/add_category";
	}
	
	@PostMapping("/edit")
	String editCategory(@ModelAttribute Category category)
	{
		if(MainValidation.validateCategory(category))
		{
			if(categoryService.updateCategory(category))
			{
				return "redirect:/admin/category";
			}
		}
		
		return "";
	}
	
	@GetMapping("/delete")
	String deleteCategory(@RequestParam Long id)
	{
		if(categoryService.deleteCategory(id))
		{
			return "redirect:/admin/category";
		}
		return "";
	}
	
	
	

}
