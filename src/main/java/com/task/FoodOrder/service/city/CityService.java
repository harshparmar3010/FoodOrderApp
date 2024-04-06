package com.task.FoodOrder.service.city;

import java.util.List;

import com.task.FoodOrder.entity.City;

public interface CityService {
    List<City> getAllCities();
    City getCityById(Long id);
    boolean saveCity(City city);
    boolean updateCity(City city);
    boolean deleteCity(Long id);
    long getCount();
}
