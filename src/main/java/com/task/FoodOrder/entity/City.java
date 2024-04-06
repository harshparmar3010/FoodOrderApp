package com.task.FoodOrder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_city", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cityName")
})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name;
    

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;


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


	public City(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public City() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
    
    
}

