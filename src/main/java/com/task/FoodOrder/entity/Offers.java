package com.task.FoodOrder.entity;

import java.time.LocalDateTime;

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
@Table(name="tbl_offers")
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="name",nullable = false, length = 255)
	private String name;
	
	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Column(name= "start_date", nullable = false)
	private LocalDateTime startDateTime;
	
	@Column(name="end_date", nullable = false)
	private LocalDateTime endDateTime;
	
	@Column(name = "discount",nullable = false)
	private int discount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="restaurant_id", nullable = false)
	private Restaurant restaurant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id",nullable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sub_category_id",nullable = false)
	private SubCategory subCategory;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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

	public Offers(Long id, String name, String description, LocalDateTime startDateTime, LocalDateTime endDateTime,
			int discount, Restaurant restaurant, Category category, SubCategory subCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.discount = discount;
		this.restaurant = restaurant;
		this.category = category;
		this.subCategory = subCategory;
	}
	
	

	public Offers(String name, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, int discount,
			Restaurant restaurant, Category category, SubCategory subCategory) {
		super();
		this.name = name;
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.discount = discount;
		this.restaurant = restaurant;
		this.category = category;
		this.subCategory = subCategory;
	}

	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Offers [id=" + id + ", name=" + name + ", description=" + description + ", startDateTime="
				+ startDateTime + ", endDateTime=" + endDateTime + ", discount=" + discount + ", restaurant=" + restaurant
				+ ", category=" + category + ", subCategory=" + subCategory + "]";
	}
	
	
}
