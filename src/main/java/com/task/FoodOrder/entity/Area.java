package com.task.FoodOrder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_area", uniqueConstraints = {
        @UniqueConstraint(columnNames = "areaName")
})
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_area_city"))
    private City city;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public Area(Long id, City city, String name, String description) {
		super();
		this.id = id;
		this.city = city;
		this.name = name;
		this.description = description;
	}

	public Area(City city, String name, String description) {
		super();
		this.city = city;
		this.name = name;
		this.description = description;
	}

	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", city=" + city + ", name=" + name + ", description=" + description + "]";
	}

    
}
