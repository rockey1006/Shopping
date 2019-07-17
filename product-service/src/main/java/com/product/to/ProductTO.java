package com.product.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.product.entity.ProductEntity;
import com.product.enums.Category;

public class ProductTO {

	private Long id;
	
	@NotNull
	@NotEmpty
	private double price;
	
	@NotNull
	@NotEmpty
	private Category category;
	
	@NotNull
	@NotEmpty
	private String brand;
	
	@NotNull
	@NotEmpty
	private String model;
	
	@NotNull
	@NotEmpty
	private double weight;
	
	@NotNull
	@NotEmpty
	private String picture;

	public ProductTO(String picture, Long id, double price, Category category,
			String brand,String model,double weight) {
		this.picture = picture;
		this.id = id;
		this.price = price;
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.weight = weight;
	}
	
	public ProductTO(ProductEntity productEntity) {
		this.picture = productEntity.getPicture();
		this.id = productEntity.getId();
		this.price = productEntity.getPrice();
		this.category = productEntity.getCategory();
		this.brand = productEntity.getBrand();
		this.model = productEntity.getModel();
		this.weight = productEntity.getWeight();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
