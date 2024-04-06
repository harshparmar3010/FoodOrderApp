package com.task.FoodOrder.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private	Long id;
	
	@Column(name="name", nullable = false, length = 255)
	private String name;
	
	@Column(name="image", nullable = false)
	private byte[] image;
	
	@Column(name="price", nullable = false)
	private int price;
	
	@Column(name="description",nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sub_category_id", nullable=false)
	private SubCategory subCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = false)
	private Restaurant restaurant;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Product(Long id, String name, byte[] image, int price, String description, Category category,
			SubCategory subCategory, Restaurant restaurant) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.category = category;
		this.subCategory = subCategory;
		this.restaurant = restaurant;
	}

	public Product(String name, byte[] image, int price, String description, Category category, SubCategory subCategory,
			Restaurant restaurant) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.category = category;
		this.subCategory = subCategory;
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + Arrays.toString(image) + ", price=" + price
				+ ", description=" + description + ", category=" + category + ", subCategory=" + subCategory
				+ ", restaurant=" + restaurant + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
