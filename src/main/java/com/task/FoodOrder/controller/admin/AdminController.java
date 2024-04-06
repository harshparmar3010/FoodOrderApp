package com.task.FoodOrder.controller.admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.entity.Offers;
import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.entity.SubCategory;
import com.task.FoodOrder.service.area.AreaService;
import com.task.FoodOrder.service.category.CategoryService;
import com.task.FoodOrder.service.city.CityService;
import com.task.FoodOrder.service.offers.OffersService;
import com.task.FoodOrder.service.product.ProductService;
import com.task.FoodOrder.service.restaurant.RestaurantService;
import com.task.FoodOrder.service.sub_category.SubCategoryService;
import com.task.FoodOrder.validation.MainValidation;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	OffersService offersService;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping
	String dashboard(Model model) {
		model.addAttribute("cityCount", cityService.getCount());
		model.addAttribute("areaCount", areaService.getCount());
		model.addAttribute("categoryCount", categoryService.getCount());
		model.addAttribute("subCategoryCount", subCategoryService.getCount());
		model.addAttribute("productCount", productService.getCount());
		model.addAttribute("offersCount", offersService.getCount());
		model.addAttribute("restaurantCount", restaurantService.getCount());
		return "admin/home";
	}
	
	@GetMapping("/restaurant")
	String manageRestaurant(Model model)
	{
		model.addAttribute("restaurantList", restaurantService.getAllRestaurants());
		return "admin/restaurant/main";
	}
	
	@GetMapping("/restaurant/add")
	String addRestaurantPage(Model model)
	{
		model.addAttribute("action", "add");
		model.addAttribute("cityList", cityService.getAllCities());
		return "admin/restaurant/add_restaurant";
	}
	
	@PostMapping("/restaurant/add")
	public String addRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, 
            @RequestParam("cityId") Long cityId,
            @RequestParam("areaId") Long areaId,
            @RequestParam("password") String password) {
		City city = cityService.getCityById(cityId);
		Area area = areaService.getAreaById(areaId);
		
		if (city != null && area != null) 
		{
			restaurant.setCity(city);
			restaurant.setArea(area);
			restaurant.setPassword(passwordEncoder.encode(password.trim()));
			restaurant.setAddress(restaurant.getAddress().trim());
			restaurant.setEmail(restaurant.getEmail().trim());
			restaurant.setName(restaurant.getName().trim());
			if(MainValidation.validateRestaurant(restaurant,password,true))
			{
				restaurantService.saveRestaurant(restaurant);
				return "redirect:/admin/restaurant";
			}
			else {
				return "";
			}
		}
		return "";
	}
	
	
	@GetMapping("/restaurant/edit")
	String editRestaurantPage(@RequestParam("id") Long id,Model model)
	{
		try {
			Restaurant restaurant = restaurantService.getRestaurantById(id);
			if(restaurant!=null)
			{
				model.addAttribute("action", "edit");
				model.addAttribute("restaurant",restaurant);
				model.addAttribute("cityList", cityService.getAllCities());
				model.addAttribute("areaList", areaService.getAreaByCity(restaurant.getCity()));
				return "admin/restaurant/add_restaurant";
			}
			
		} catch (Exception e) {
			return "";
		}
		return "";
	}
	
	@PostMapping("/restaurant/edit")
	public String editRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, 
            @RequestParam("cityId") Long cityId,
            @RequestParam("areaId") Long areaId,
            @RequestParam("password") String password) {
		try {
			City city = cityService.getCityById(cityId);
			Area area = areaService.getAreaById(areaId);
			if (city != null && area != null) 
			{
				restaurant.setCity(city);
				restaurant.setArea(area);
				restaurant.setPassword(password.trim());
				restaurant.setAddress(restaurant.getAddress().trim());
				restaurant.setEmail(restaurant.getEmail().trim());
				restaurant.setName(restaurant.getName().trim());
				if(MainValidation.validateRestaurant(restaurant,"",false))
				{
					restaurantService.updateRestaurant(restaurant.getId(), restaurant);
				}
				return "redirect:/admin/restaurant";
			}
		} catch (Exception e) {
			return "";
		}
		
		return "";
	}
	
	@GetMapping("/restaurant/delete")
	String deleteRestaurant(@RequestParam("id") Long id)
	{
		if(restaurantService.deleteRestaurant(id))
		{
			return "redirect:/admin/restaurant";
		}
		return "";
	}
	
	@GetMapping("/offers")
	String manageOffers(Model model)
	{
		model.addAttribute("offersList", offersService.getAllOffers());
		return "admin/offer/main";
	}
	
	@GetMapping("/offers/add")
	String addOffersPage(Model model,HttpServletRequest request)
	{
		model.addAttribute("action", "add");
		model.addAttribute("categoryList", categoryService.getAllCategories());
		model.addAttribute("restaurantList", restaurantService.getAllRestaurants());
		return "admin/offer/add_offers";
	}
	
	@PostMapping("/offers/add")
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
					return "redirect:/admin/offers";
				}
				return "";
			}
			return "";
		} catch (Exception e) {
			return "";
		}
		
	}
	
	
	@GetMapping("/offers/edit")
	String editOffersPage(@RequestParam("id") Long id,Model model,HttpServletRequest request)
	{
		Offers offers = offersService.getOffersById(id);
		if(offers!=null)
		{
			model.addAttribute("action", "edit");
			model.addAttribute("offers", offers);
			model.addAttribute("categoryList", categoryService.getAllCategories());
			model.addAttribute("subCategoryList", subCategoryService.getSubCategoryByCategory(offers.getCategory()));
			model.addAttribute("restaurantList", restaurantService.getAllRestaurants());
			return "admin/offer/add_offers";
		}
		return "";
		
	}
	
	@PostMapping("/offers/edit")
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
					return "redirect:/admin/offers";
				}
				return "";
			}
			return "";
		} catch (Exception e) {
			return "";
		}
		
	}
	
	@GetMapping("/offers/delete")
	String deleteOffers(@RequestParam("id") Long id)
	{
		try {
			offersService.deleteOffers(id);
			return "redirect:/admin/offers";
		} catch (Exception e) {
			return "";
		}
		
	}
	
	
	
}

