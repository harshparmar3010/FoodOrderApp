package com.task.FoodOrder.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.FoodOrder.entity.City;
import com.task.FoodOrder.service.city.CityService;
import com.task.FoodOrder.validation.MainValidation;

@Controller
@RequestMapping("/admin/city")
public class CityController {
	@Autowired
	CityService cityService;
	
	
	@GetMapping({"/",""})
	String manageCityPage(Model model) {
		List<City> cities = cityService.getAllCities();
		System.out.println(cities);
		model.addAttribute("cities",cities);
		return "admin/city/main";
	}
	
	@GetMapping("/add")
	String addCityPage(Model model) {
		model.addAttribute("action","add");
		return "admin/city/add_city";
	}
	
	@PostMapping("/add")
	String addCity(@ModelAttribute City city) {
		if(MainValidation.validateCity(city))
		{
			if(cityService.saveCity(city))
			{
				return "redirect:/admin/city";
			}
		}
		return "";
	}
	@GetMapping("/edit")
	String editCityPage(@RequestParam Long id, Model model)
	{
		City city = cityService.getCityById(id);
		if(city!=null)
		{
			model.addAttribute("action","edit");
			model.addAttribute("city", city);
			return "admin/city/add_city";
		}
		return "";
	}
	@PostMapping("/edit")
	String editCity(@ModelAttribute City city) {
		if(MainValidation.validateCity(city)) {
			if(cityService.updateCity(city))
			{
				return "redirect:/admin/city";
			}
		}
		return "";
	}
	
	@GetMapping("/delete")
	String deleteCity(@RequestParam Long id) {
		
		if(cityService.deleteCity(id))
		{
			return "redirect:/admin/city";
		}
		return "";
	}
}
