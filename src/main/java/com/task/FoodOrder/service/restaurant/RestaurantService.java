package com.task.FoodOrder.service.restaurant;

import java.util.List;

import com.task.FoodOrder.entity.Restaurant;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(Long id);

    boolean saveRestaurant(Restaurant restaurant);

    boolean updateRestaurant(Long id, Restaurant restaurant);

    boolean deleteRestaurant(Long id);
    
    Restaurant getRestaurantByEmail(String email);
    
    long getCount();
    
    boolean emailExist(String email);
    
    boolean contactExist(Long contact);
}
