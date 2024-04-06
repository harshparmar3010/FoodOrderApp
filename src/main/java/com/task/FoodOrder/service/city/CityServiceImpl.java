package com.task.FoodOrder.service.city;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.repository.CityRepository;
import com.task.FoodOrder.service.area.AreaService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private AreaService areaService;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public boolean saveCity(City city) {
        try {
            cityRepository.save(city);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCity(City city) {
        City existingCity = cityRepository.findById(city.getId()).orElse(null);
        try {
            existingCity.setName(city.getName());
            existingCity.setDescription(city.getDescription());
            List<Area> areas = areaService.getAreaByCity(existingCity);
            for (Area area : areas) {
                area.setCity(existingCity);
                areaService.saveArea(area);
            }
            cityRepository.save(existingCity);
            return true;
        }
        catch (Exception e) {
        	return false;
		}
        
    }

    @Override
    public boolean deleteCity(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        
        if (city != null) {
            for (Area area : areaService.getAreaByCity(city)) {
                areaService.deleteArea(area.getId());
            }
            
            cityRepository.delete(city);
            
            return true;
        }
        
        return false;
    }

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return cityRepository.count();
	}
}
