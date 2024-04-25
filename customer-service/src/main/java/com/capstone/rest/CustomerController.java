package com.capstone.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capstone.entity.Customer;
import com.capstone.exception.CustomerAlreadyExists;
import com.capstone.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String addCustomer(@RequestBody Customer c) {
		
		try {
			service.add(c);
			return "Customer added successfully";
		} catch (Exception e) {
			throw new CustomerAlreadyExists("customer already exists");
		}
	}

	
	@GetMapping(value = "/find/{custid}", produces = "application/json")
	public Customer find(@PathVariable String custid) {
		try {
			return service.find(custid);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());

		}
	}

	@GetMapping(value = "/list", produces = "application/json")
	public List<Customer> list() {
		return service.list();

	}

	@GetMapping(value = "/authenticate", produces = "application/json")
	public Customer authenticate(@RequestParam String custid, @RequestParam String password) {
		return service.authenticate(custid, password);
		
	}

}
