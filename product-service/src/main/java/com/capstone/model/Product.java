package com.capstone.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private int id;
	private String name;
	private String category;
	private double price;
	private boolean available;
	private String image;

	public Product() {
	}

	public Product(int id, String name, String category, double price, boolean available, String image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.available = available;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
