package com.task.FoodOrder.service.area;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.repository.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    @Override
    public Area getAreaById(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean saveArea(Area area) {
    	try {
            areaRepository.save(area);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteArea(Long id) {
        areaRepository.deleteById(id);
        if(!areaRepository.existsById(id))
        	return true;
        return false;
    }
    
    @Override
    public boolean updateArea(Area area) {
        try {
            if (areaRepository.existsById(area.getId())) {
                areaRepository.save(area);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

	@Override
	public List<Area> getAreaByCity(City city) {
		
		return areaRepository.findByCity(city);
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return areaRepository.count();
	}
}
