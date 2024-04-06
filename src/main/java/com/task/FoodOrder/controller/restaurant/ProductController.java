package com.task.FoodOrder.controller.restaurant;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.task.FoodOrder.ImageUtils;
import com.task.FoodOrder.entity.Category;
import com.task.FoodOrder.entity.Product;
import com.task.FoodOrder.entity.Restaurant;
import com.task.FoodOrder.entity.SubCategory;
import com.task.FoodOrder.service.category.CategoryService;
import com.task.FoodOrder.service.product.ProductService;
import com.task.FoodOrder.service.restaurant.RestaurantService;
import com.task.FoodOrder.service.sub_category.SubCategoryService;
import com.task.FoodOrder.validation.MainValidation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/restaurant/product")
public class ProductController {

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@GetMapping({"/",""})
	String manageProduct(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long idLong  =  (Long) session.getAttribute("restaurant_id");
		model.addAttribute("productList", productService.getAllProductsByRestaurantId(idLong));
		return "restaurant/product/main";
	}
	
	@GetMapping("/image")
	@ResponseBody
	String showProductImage(@RequestParam("data") Long id)
	{
		Product product = productService.getProductById(id);
		
		return "<html><body><img src=\"data:image/jpeg;base64,"+ImageUtils.convertToBase64(product.getImage())+"\" /></body></html>";
	}
	
	@GetMapping("/add")
	String addProductPage(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		model.addAttribute("action", "add");
		model.addAttribute("restaurant_id", session.getAttribute("restaurant_id").toString());
		model.addAttribute("categoryList", categoryService.getAllCategories());
		return "restaurant/product/add_product";
	}
	
	@PostMapping("/add")
	String addProduct(
			@RequestParam("name") String name,
			@RequestParam("price") int price,
			@RequestParam("description") String description,
			@RequestParam("image") MultipartFile image,
			@RequestParam("subCategoryId") Long subCategoryId,
			@RequestParam("categoryId") Long categoryId,
			@RequestParam("restaurantId") Long restaurantId)
	{
		byte[] imageData = null;
        try {
        	imageData = image.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Category category = categoryService.getCategoryById(categoryId);
        SubCategory subCategory = subCategoryService.getSubCategoryById(subCategoryId);
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        
        if(category!=null && subCategory!=null && restaurant!=null)
        {
            Product product = new Product(name,imageData,price,description,category,subCategory,restaurant);
            if(MainValidation.validateProduct(product))
            {
            	if(productService.saveProduct(product))
                {
                	return "redirect:/restaurant/product";
                }
            }	
        }
        return "";
        
        
	}
	
	@GetMapping("/edit")
	String editProductPage(@RequestParam("id") Long id, Model model, HttpServletRequest request)
	{
		Product product = productService.getProductById(id);
		if(product!=null)
		{
			HttpSession session = request.getSession();
			model.addAttribute("action", "edit");
			model.addAttribute("product", product);
			model.addAttribute("restaurant_id", session.getAttribute("restaurant_id").toString());
			model.addAttribute("categoryList", categoryService.getAllCategories());
			model.addAttribute("subCategoryList", subCategoryService.getSubCategoryByCategory(product.getCategory()));
			return "restaurant/product/add_product";
		}
		return "";
	}
	
	@PostMapping("/edit")
	String editProduct(
			@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("price") int price,
			@RequestParam("description") String description,
			@RequestParam("image") MultipartFile image,
			@RequestParam("subCategoryId") Long subCategoryId,
			@RequestParam("categoryId") Long categoryId,
			@RequestParam("restaurantId") Long restaurantId)
	{
		
		byte[] imageData = productService.getProductById(id).getImage();
        try {
        	if (image != null && !image.isEmpty()) {
        		imageData = image.getBytes();
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        Category category = categoryService.getCategoryById(categoryId);
        SubCategory subCategory = subCategoryService.getSubCategoryById(subCategoryId);
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if(category!=null && subCategory!=null)
        {
        	Product product = new Product(id,name,imageData,price,description,category,subCategory,restaurant);
        	if(MainValidation.validateProduct(product))
        	{
        		if(productService.updateProduct(product))
                {
                	return "redirect:/restaurant/product";
                }
        	}
        }
        return "";
        
        
	}
	
	@GetMapping("/delete")
	String deleteProduct(@RequestParam("id") Long id)
	{
		if(productService.deleteProduct(id))
		{
			return "redirect:/restaurant/product";
		}
		return "";
	}
	
	
	
}
