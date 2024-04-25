package com.capstone.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capstone.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{
	
	
	List<Product> findByCategory(String category);   //explicitly ,creating for list by category
	
	
	
}
