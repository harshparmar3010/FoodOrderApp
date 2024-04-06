package com.task.FoodOrder.controller;

import java.util.List;

import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.FoodOrder.controller.admin.AdminController;
import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.entity.SubCategory;
import com.task.FoodOrder.service.area.AreaService;
import com.task.FoodOrder.service.category.CategoryService;
import com.task.FoodOrder.service.city.CityService;
import com.task.FoodOrder.service.restaurant.RestaurantService;
import com.task.FoodOrder.service.sub_category.SubCategoryService;
import com.task.FoodOrder.validation.MainValidation;

@Controller
public class MainController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping({"","/"})
	public String home() {
		var res = UtilesFunctions.getInstance().authDetect(restaurantService);
		if(res!=null)
		{
			return res;
		}
		return "redirect:/login";
	}
	
	@GetMapping("/403")
	public String accessDeny() {
		return "403";
	}
	
	@GetMapping("/login")
	String loginPage() {
		var res = UtilesFunctions.getInstance().authDetect(restaurantService);
		if(res!=null)
		{
			return res;
		}
		return "login";
	}
	
	@GetMapping("/registration")
	String registrationPage(Model model) {
		var res = UtilesFunctions.getInstance().authDetect(restaurantService);
		if(res!=null)
		{
			return res;
		}
		model.addAttribute("cityList", cityService.getAllCities());
		model.addAttribute("action", "register");
		return "registration";
	}
	
	
	@PostMapping("/getAreas")
    @ResponseBody
    public List<Area> getAreas(@RequestParam Long cityId) {
        City city = cityService.getCityById(cityId);
        
        if(city!=null)
        {
        	List<Area> areaList = areaService.getAreaByCity(city);
        	return areaList;
        }
        return null;
        
    }
	
	@PostMapping("/getSubCategory")
    @ResponseBody
    public List<SubCategory> getSubCategory(@RequestParam Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        
        if(category!=null)
        {
        	List<SubCategory> subCategoryList = subCategoryService.getSubCategoryByCategory(category);
        	return subCategoryList;
        }
        return null;
        
    }
	
	
	
	@PostMapping("/registration")
    public String addRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, 
                                @RequestParam("cityId") Long cityId,
                                @RequestParam("areaId") Long areaId,
                                @RequestParam("password") String password,
                                Model model) {
		var res = UtilesFunctions.getInstance().authDetect(restaurantService);
		if(res!=null)
		{
			return res;
		}
        City city = cityService.getCityById(cityId);
        Area area = areaService.getAreaById(areaId);
        if(city!=null && area != null)
        {
        	restaurant.setCity(city);
            restaurant.setArea(area);
            restaurant.setPassword(passwordEncoder.encode(password));
            try {
            	if(MainValidation.validateRestaurant(restaurant,password,true))
            	{
            		restaurantService.saveRestaurant(restaurant);
            	}
            	return "";
            }
            catch (DataIntegrityViolationException e) {
            	if(restaurantService.emailExist(restaurant.getEmail()))
            	{
            		return "redirect:/registration?error=DataIntegrityViolationException&&email=true";
            	}
            	if(restaurantService.contactExist(restaurant.getContactNo()))
            	{
            		return "redirect:/registration?error=DataIntegrityViolationException&&contact=true";
            	}
				
			}
            

            return "redirect:/login";
        }
        return "";
    }
	
	@PostMapping("/checkEmail")
    public ResponseEntity<?> checkEmailExistence(@RequestParam String email) {
        
        if (restaurantService.emailExist(email)) {
        	System.out.println("checkemail: true");
            return ResponseEntity.ok().body("{\"exists\": true}");
        } else {
        	System.out.println("checkemail: false");
            return ResponseEntity.ok().body("{\"exists\": false}");
        }
    }
	
}
