package com.task.FoodOrder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_restaurant")
public class Restaurant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;

    @Column(name="name",nullable = false, length = 50)
    private String name;

    @Column(name="email",nullable = false, unique = true, length = 320)
    private String email;

    @Column(name = "contact_no", nullable = false, unique = true)
    private Long contactNo;

    @Column(name="address",nullable = false, columnDefinition = "TEXT")
    private String address;

    
    @Column(name="password",nullable = false)
    private String password;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Restaurant(Long id, String name, String email, Long contactNo, String address, String password, City city,
			Area area) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.password = password;
		this.city = city;
		this.area = area;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", address=" + address + ", password=" + password + ", city=" + city + ", area=" + area + "]";
	}
    
    
}
