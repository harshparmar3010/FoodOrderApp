package com.task.FoodOrder.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.task.FoodOrder.service.restaurant.RestaurantService;

public class UtilesFunctions {
	
	
	static UtilesFunctions utilesFunctions=null;
	
	public static UtilesFunctions getInstance() {
		if(utilesFunctions==null)
		{
			utilesFunctions = new UtilesFunctions();
		}
		return utilesFunctions;
	}
	
	public boolean validateLoginUser(Long id,RestaurantService restaurantService)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName  = userDetails.getUsername();
        
		var user = restaurantService.getRestaurantById(id);
		if(user==null)
		{
			return false;
		}
		return currentUserName.equals(user.getEmail());
		
	}
	
	String authDetect(RestaurantService restaurantService)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
		    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		    boolean isRestaurant = userDetails.getAuthorities().stream()
		        .anyMatch(authority -> authority.getAuthority().equals("ROLE_RESTAURANT"));
		    
		    if (isRestaurant) {
		    	return "redirect:/restaurant/"+restaurantService.getRestaurantByEmail(userDetails.getUsername()).getId();
		    } else {
		    	return "redirect:/admin";
		    }
		} else {
		    
			return null;
		}
	}
	
}
