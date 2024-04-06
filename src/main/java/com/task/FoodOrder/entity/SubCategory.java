package com.task.FoodOrder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
   
    @ManyToOne
    @JoinColumn(name = "categoty_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_subCategory_category"))
    private Category category;

    @Column(name = "name", nullable = false, length = 255)
    private String name;
    

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
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


	public SubCategory(Long id, Category category, String name, String description) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
	}


	public SubCategory(Category category, String name, String description) {
		super();
		this.category = category;
		this.name = name;
		this.description = description;
	}


	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "SubCategory [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
				+ "]";
	}
    

	    
}
