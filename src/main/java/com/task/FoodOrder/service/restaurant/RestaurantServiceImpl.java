package com.task.FoodOrder.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public boolean saveRestaurant(Restaurant restaurant) {
        if (restaurant != null) {
            restaurantRepository.save(restaurant);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = restaurantRepository.findById(id).orElse(null);
        if (existingRestaurant!=null) {          
            existingRestaurant.setName(restaurant.getName());
            existingRestaurant.setEmail(restaurant.getEmail());
            existingRestaurant.setContactNo(restaurant.getContactNo());
            existingRestaurant.setAddress(restaurant.getAddress());
            existingRestaurant.setCity(restaurant.getCity());
            existingRestaurant.setArea(restaurant.getArea());
            existingRestaurant.setPassword(restaurant.getPassword());
            restaurantRepository.save(existingRestaurant);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRestaurant(Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            restaurantRepository.deleteById(id);
            return true;
        }
        return false;
    }

	@Override
	public Restaurant getRestaurantByEmail(String email) {
		// TODO Auto-generated method stub
		return restaurantRepository.findByEmail(email);
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return restaurantRepository.count();
	}

	@Override
	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		return restaurantRepository.existsByEmail(email);
	}

	@Override
	public boolean contactExist(Long contact) {
		// TODO Auto-generated method stub
		return restaurantRepository.existsByContactNo(contact);
	}
}

