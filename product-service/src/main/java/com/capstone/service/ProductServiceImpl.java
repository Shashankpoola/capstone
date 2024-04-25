package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.capstone.exception.ProductAlreadyExistsException;
import com.capstone.model.Product;
import com.capstone.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	//the save findbyid deletebyid listall are coming from crud repository which is in mongo repository
	
	
	@Override
	public Product add(Product p) {
		
		return repo.save(p);
	}

	@Override
	public Product find(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);

	}

	@Override
	public Product update(Product p) {

		return repo.save(p);
	}

	@Override
	public List<Product> listByCategory(String category) {

		return repo.findByCategory(category);
	}

}
