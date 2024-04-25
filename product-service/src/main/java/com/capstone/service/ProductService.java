package com.capstone.service;

import java.util.List;

import com.capstone.model.Product;

public interface ProductService {
	
	
	Product add(Product p);
	
	Product find(int id);
	
	List<Product> list();
	
	void delete(int id);
	
	Product update(Product p);
	
	List<Product> listByCategory(String category);
	
}
