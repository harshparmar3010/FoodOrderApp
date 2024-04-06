package com.task.FoodOrder.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.FoodOrder.controller.UtilesFunctions;
import com.task.FoodOrder.service.offers.OffersService;
import com.task.FoodOrder.service.product.ProductService;
import com.task.FoodOrder.service.restaurant.RestaurantService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	OffersService offersService;
	
	@Autowired
	ProductService productService;
		
	@GetMapping("/{id}")
	String restaurantDashboard(@PathVariable("id") Long id,HttpServletRequest request,Model model)
	{
		if(!UtilesFunctions.getInstance().validateLoginUser(id, restaurantService))
		{
			return "redirect:/403";
		}
		model.addAttribute("restaurant_id", id);
		HttpSession session = request.getSession();
		session.setAttribute("restaurant_id", id);
		model.addAttribute("offersCount", offersService.getOffersCountByRestaurantId(id));
		model.addAttribute("productsCount", productService.getProductsCountByRestaurantId(id));
		return "restaurant/home";
	}
}
