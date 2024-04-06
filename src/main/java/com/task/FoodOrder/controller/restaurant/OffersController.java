package com.task.FoodOrder.controller.restaurant;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.Offers;
import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.entity.SubCategory;
import com.task.FoodOrder.service.category.CategoryService;
import com.task.FoodOrder.service.offers.OffersService;
import com.task.FoodOrder.service.restaurant.RestaurantService;
import com.task.FoodOrder.service.sub_category.SubCategoryService;
import com.task.FoodOrder.validation.MainValidation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/restaurant/offers")
public class OffersController {

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	OffersService offersService;
	
	@GetMapping({"/",""})
	String manageOffers(Model model,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Long resIdLong = (Long) session.getAttribute("restaurant_id");
		model.addAttribute("offersList", offersService.getOffersByRestaurantId(resIdLong));
		model.addAttribute("restaurant_id",resIdLong);
		return "restaurant/offer/main";
	}
	
	@GetMapping("/add")
	String addOffersPage(Model model,HttpServletRequest request)
	{
		model.addAttribute("action", "add");
		model.addAttribute("categoryList", categoryService.getAllCategories());
		return "restaurant/offer/add_offers";
	}
	
	@PostMapping("/add")
	String addOffers(
			@ModelAttribute Offers offers,
			@RequestParam("categoryId") Long categoryId,
			@RequestParam("restaurantId") Long restaurantId,
			@RequestParam("subCategoryId") Long subCategoryId
			) 
	{
		try {
			Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
			Category category = categoryService.getCategoryById(categoryId);
			SubCategory subCategory = subCategoryService.getSubCategoryById(subCategoryId);
			
			if(restaurant!=null && category!=null && subCategory!=null)
			{
				offers.setRestaurant(restaurant);
				offers.setCategory(category);
				offers.setSubCategory(subCategory);
				offers.setName(offers.getName().trim());
				offers.setDescription(offers.getDescription().trim());
				if(MainValidation.validateOffer(offers))
				{
					offersService.saveOffers(offers);
					return "redirect:/restaurant/offers";
				}
				
			}
			return "";
		} catch (Exception e) {
			return "";
		}
		
	}
	
	
	
	@GetMapping("/edit")
	String editOffersPage(@RequestParam("id") Long id,Model model,HttpServletRequest request)
	{
		Offers offers = offersService.getOffersById(id);
		if(offers!=null)
		{
			model.addAttribute("action", "edit");
			model.addAttribute("offers", offers);
			model.addAttribute("categoryList", categoryService.getAllCategories());
			model.addAttribute("subCategoryList", subCategoryService.getSubCategoryByCategory(offers.getCategory()));
			return "restaurant/offer/add_offers";
		}
		return "";
		
	}
	
	@PostMapping("/edit")
	String editOffers(@ModelAttribute Offers offers,
			@RequestParam("restaurantId") Long restaurantId,
			@RequestParam("categoryId") Long categoryId,
			@RequestParam("subCategoryId") Long subCategoryId 
			) 
	{
		try {
			Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
			Category category = categoryService.getCategoryById(categoryId);
			SubCategory subCategory = subCategoryService.getSubCategoryById(subCategoryId);
			
			if(restaurant!=null && category!=null && subCategory!=null)
			{
				offers.setRestaurant(restaurant);
				offers.setCategory(category);
				offers.setSubCategory(subCategory);
				offers.setName(offers.getName().trim());
				offers.setDescription(offers.getDescription().trim());
				if(MainValidation.validateOffer(offers))
				{
					offersService.updateOffers(offers);
					return "redirect:/restaurant/offers";
				}
				
				
			}
			return "";
		} catch (Exception e) {
			return "";
		}
		
	}
	
	@GetMapping("/delete")
	String deleteOffers(@RequestParam("id") Long id)
	{
		try {
			offersService.deleteOffers(id);
			return "redirect:/restaurant/offers";
		} catch (Exception e) {
			return "";
		}
		
	}
	
	
}
