package com.task.FoodOrder.service.offers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Offers;
import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.repository.OffersRepository;
import com.task.FoodOrder.service.restaurant.RestaurantService;

@Service
public class OffersServiceImpl implements OffersService {
	
	@Autowired
	OffersRepository offersRepository;
	
	@Autowired
	RestaurantService restaurantService;

	@Override
	public List<Offers> getAllOffers() {
		// TODO Auto-generated method stub
		return offersRepository.findAll();
	}

	@Override
	public Offers getOffersById(Long id) {
		// TODO Auto-generated method stub
		return offersRepository.findById(id).orElse(null);
	}

	@Override
	public boolean saveOffers(Offers offers) {
		try {
			offersRepository.save(offers);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateOffers(Offers offers) {
		try {
			offersRepository.save(offers);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteOffers(Long id) {
		try {
			offersRepository.deleteById(id);
			if(offersRepository.existsById(id))
			{
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Offers> getOffersByRestaurantId(Long id) {
		Restaurant restaurant = restaurantService.getRestaurantById(id);
		return offersRepository.findByRestaurant(restaurant);
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return offersRepository.count();
	}

	@Override
	public long getOffersCountByRestaurantId(Long restaurantId) {
		// TODO Auto-generated method stub
		return offersRepository.countByRestaurantId(restaurantId);
	}

}
