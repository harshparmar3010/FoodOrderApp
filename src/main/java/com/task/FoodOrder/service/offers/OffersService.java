package com.task.FoodOrder.service.offers;

import java.util.List;

import com.task.FoodOrder.entity.Offers;

public interface OffersService {
	List<Offers> getAllOffers();
    Offers getOffersById(Long id);
    boolean saveOffers(Offers offers);
    boolean updateOffers(Offers offers);
    boolean deleteOffers(Long id);
    List<Offers> getOffersByRestaurantId(Long id);
    long getCount();
    long getOffersCountByRestaurantId(Long restaurantId);
}
