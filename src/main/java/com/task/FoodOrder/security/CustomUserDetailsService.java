package com.task.FoodOrder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.service.restaurant.RestaurantService;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private RestaurantService restaurantService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        Restaurant restaurant = restaurantService.getRestaurantByEmail(username);
        
        if (restaurant != null) {
        	
        		return User.withUsername(restaurant.getEmail())
                        .password(restaurant.getPassword())
                        .roles("RESTAURANT")
                        .build();
        	
        }
        else {
        	if("admin@gmail.com".equals(username))
        	{
        		return User.withUsername("admin@gmail.com")
                .password(passwordEncoder.encode("Sttl@1234"))
                .roles("ADMIN").build();
        	}
        	throw new UsernameNotFoundException("User not found with username: " + username);
        }
        

        
    }

}
