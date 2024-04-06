package com.task.FoodOrder.service.area;

import java.util.List;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.City;

public interface AreaService {
    List<Area> getAllAreas();
    Area getAreaById(Long id);
    boolean saveArea(Area area);
    boolean deleteArea(Long id);
    boolean updateArea(Area area);
    List<Area> getAreaByCity(City city);
    long getCount();
}
