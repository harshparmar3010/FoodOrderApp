package com.task.FoodOrder.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.FoodOrder.entity.Product;
import com.task.FoodOrder.repository.ProductRepository;
import com.task.FoodOrder.service.restaurant.RestaurantService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	RestaurantService restaurantService;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public boolean saveProduct(Product product) {
		try {
			productRepository.save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Long id) {
		try {
			productRepository.deleteById(id);
			if(!productRepository.existsById(id))
			{
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			productRepository.save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Product> getAllProductsByRestaurantId(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findByRestaurant(restaurantService.getRestaurantById(id));
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return productRepository.count();
	}

	@Override
	public long getProductsCountByRestaurantId(Long restaurantId) {
		// TODO Auto-generated method stub
		return productRepository.countByRestaurantId(restaurantId);
	}
}
