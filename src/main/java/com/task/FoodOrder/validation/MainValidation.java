package com.task.FoodOrder.validation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.entity.Offers;
import com.task.FoodOrder.entity.Product;
import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.entity.SubCategory;

public class MainValidation {
	
	public static boolean validateRestaurant(Restaurant restaurant, String password, boolean isAdd) {
        
        String email = restaurant.getEmail().trim();
        if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            return false;
        }

        
        String contactNo = restaurant.getContactNo().toString().trim();
        if (!contactNo.matches("^\\d{10}$")) {
            return false;
        }

        
        String name = restaurant.getName().trim();
        if (name.isEmpty()) {
            return false;
        }

        
        String address = restaurant.getAddress().trim();
        if (address.isEmpty()) {
            return false;
        }

        if(isAdd)
        {
        	if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+])[A-Za-z\\d!@#$%^&*()-+]{8,20}$"))
        	{
        		return false;
        	}
        }
        
        return true;
    }
	
	public static boolean validateOffer(Offers offer) {
        
        offer.setName(offer.getName().trim());
        offer.setDescription(offer.getDescription().trim());
        
        
        if (offer.getName().isEmpty()) {
            return false;
        }

        if (offer.getDescription().isEmpty()) {
            return false;
        }
        
        if(!offer.getName().matches("^(?!\\s)(?!.*\\s$)[a-zA-Z0-9\\s_-]+$"))
        {
        	return false;
        }
        
        if(!offer.getDescription().matches("^(?! )[\\w\\s.,?!-]+(?<! )$"))
        {
        	return false;
        }

        int discount = offer.getDiscount();
        if (discount < 0 || discount > 100) {
            return false;
        }
        
        if (offer.getStartDateTime().isBefore(LocalDateTime.now())) {
            return false;
        }

        
        if (offer.getStartDateTime().isAfter(offer.getEndDateTime())) {
            return false;
        }

        
        long daysBetween = ChronoUnit.DAYS.between(offer.getStartDateTime(), offer.getEndDateTime());
        if (daysBetween > 30) {
            return false;
        }
        
        return true;
    }
	
	public static boolean validateArea(Area area) {
        
		area.setName(area.getName().trim());
		area.setDescription(area.getDescription().trim());

        
        if (area.getName().isEmpty()) {
            return false;
        }

        
        if (area.getDescription().isEmpty()) {
            return false;
        }
        
        if(!area.getName().matches("^(?!\\s)(?!.*\\s$)[a-zA-Z0-9\\s_-]+$"))
        {
        	return false;
        }
        
        if(!area.getDescription().matches("^(?! )[\\w\\s.,?!-]+(?<! )$"))
        {
        	return false;
        }

        
        return true;
    }
	
	public static boolean validateCategory(Category category) {
        
		category.setName(category.getName().trim());
		category.setDescription(category.getDescription().trim());

        
        if (category.getName().isEmpty()) {
            return false;
        }

        
        if (category.getDescription().isEmpty()) {
            return false;
        }
        
        if(!category.getName().matches("^(?!\\s)(?!.*\\s$)[a-zA-Z0-9\\s_-]+$"))
        {
        	return false;
        }
        
        if(!category.getDescription().matches("^(?! )[\\w\\s.,?!-]+(?<! )$"))
        {
        	return false;
        }

        return true;
    }
	
	public static boolean validateCity(City city) {
        
        city.setName(city.getName().trim());
        city.setDescription(city.getDescription().trim());

        
        if (city.getName().isEmpty()) {
            return false;
        }

        
        if (city.getDescription().isEmpty()) {
            return false;
        }

        if(!city.getName().matches("^(?!\\s)(?!.*\\s$)[a-zA-Z0-9\\s_-]+$"))
        {
        	return false;
        }
        
        if(!city.getDescription().matches("^(?! )[\\w\\s.,?!-]+(?<! )$"))
        {
        	return false;
        }
        
        return true;
    }
	public static boolean validateSubCategory(SubCategory subCategory) {
        
		subCategory.setName(subCategory.getName().trim());
		subCategory.setDescription(subCategory.getDescription().trim());

        
        if (subCategory.getName().isEmpty()) {
            return false;
        }

        
        if (subCategory.getDescription().isEmpty()) {
            return false;
        }

        if(!subCategory.getName().matches("^(?!\\s)(?!.*\\s$)[a-zA-Z0-9\\s_-]+$"))
        {
        	return false;
        }
        
        if(!subCategory.getDescription().matches("^(?! )[\\w\\s.,?!-]+(?<! )$"))
        {
        	return false;
        }
        
        return true;
    }
	
	public static boolean validateProduct(Product product) {
        
		product.setName(product.getName().trim());
		product.setDescription(product.getDescription().trim());

        
        if (product.getName().isEmpty()) {
            return false;
        }
        
        
        if (product.getDescription().isEmpty()) {
            return false;
        }
        
        if(!product.getName().matches("^(?!\\s)(?!.*\\s$)[a-zA-Z0-9\\s_-]+$"))
        {
        	return false;
        }
        
        if(!product.getDescription().matches("^(?! )[\\w\\s.,?!-]+(?<! )$"))
        {
        	return false;
        }
        
        if(product.getPrice()<0)
        {
        	return false;
        }

        
        return true;
    }
}
