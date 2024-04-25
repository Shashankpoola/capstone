package com.capstone.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capstone.exception.ProductAlreadyExistsException;
import com.capstone.model.Product;
import com.capstone.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@PostMapping(value = "/add", consumes = "application/json")
	public String addProduct(@RequestBody Product p) {
		try {
			int code = service.add(p).getId();
			return "Product added successfully with id" + code;
		} catch (Exception e) {
			throw new ProductAlreadyExistsException("Product already exists");
		}

	}
	
	

	@GetMapping(value = "/{id}", produces = "application/json")
	public Product find(@PathVariable int id) {
//		return service.find(id);
		try {
			return service.find(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/list", produces = "application/json")
	public List<Product> listAll() {
		return service.list();
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public void delete(@PathVariable int id) {
		service.delete(id);

	}

	@GetMapping(value = "/category/{category}", produces = "application/json")
	public List<Product> listByCategory(@PathVariable String category) {
		return service.listByCategory(category);

	}

	@PutMapping(value = "/update", consumes = "application/json")
	public Product update(@RequestBody Product p) {
		return service.update(p);

	}

}
