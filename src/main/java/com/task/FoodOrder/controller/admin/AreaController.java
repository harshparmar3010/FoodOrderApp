package com.task.FoodOrder.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.FoodOrder.entity.Area;
import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.service.area.AreaService;
import com.task.FoodOrder.service.city.CityService;
import com.task.FoodOrder.validation.MainValidation;

@Controller
@RequestMapping("/admin/area")
public class AreaController {
	
	@Autowired
	CityService cityService;
	
	
	@Autowired
	AreaService areaService;
	
	
	@GetMapping({"/",""})
	String manageAreaPage(Model model) {
		model.addAttribute("areas",areaService.getAllAreas());
		return "admin/area/main";
	}
	
	@GetMapping("/add")
	String addAreaPage(Model model) {
		model.addAttribute("action","add");
		model.addAttribute("cities", cityService.getAllCities());
		return "admin/area/add_area";
	}
	
	@PostMapping("/add")
	String addArea(
			@RequestParam Long city_id,
			@RequestParam String name,
			@RequestParam String description
			) {
		City city = cityService.getCityById(city_id);
		if(city==null)
		{
			return "";
		}
		Area area = new Area(city,name,description);
		if(MainValidation.validateArea(area))
		{
			if(areaService.saveArea(area))
			{
				return "redirect:/admin/area";
			}
		}
		
		return "";
	}
	
	@GetMapping("/edit")
	String editAreaPage(@RequestParam Long id, Model model)
	{
		Area area = areaService.getAreaById(id);
		if(area!=null)
		{
			model.addAttribute("action","edit");
			model.addAttribute("area", area);
			model.addAttribute("cities", cityService.getAllCities());
			return "admin/area/add_area";
		}
		return "";
	}
	@PostMapping("/edit")
	String editArea(
			@RequestParam Long id,
			@RequestParam Long city_id,
			@RequestParam String name,
			@RequestParam String description) {
		City city = cityService.getCityById(city_id);
		if(city==null)
		{
			return "";
		}
		Area area = new Area(id,city,name,description);
		if(MainValidation.validateArea(area))
		{
			if(areaService.updateArea(area))
			{
				return "redirect:/admin/area";
			}
		}
		
		return "";
	}
	
	@GetMapping("/delete")
	String deleteArea(@RequestParam Long id) {
		if(areaService.deleteArea(id))
		{
			return "redirect:/admin/area";
		}
		return "";
	}
	

	
}
