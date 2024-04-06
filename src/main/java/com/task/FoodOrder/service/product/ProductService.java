package com.task.FoodOrder.service.product;

import java.util.List;

import com.task.FoodOrder.entity.Product;

public interface ProductService {
	public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public boolean saveProduct(Product product);

    public boolean deleteProduct(Long id);

    public boolean updateProduct(Product product);
    
    public List<Product> getAllProductsByRestaurantId(Long id);
    long getCount();
    long getProductsCountByRestaurantId(Long restaurantId);
}
