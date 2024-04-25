package com.capstone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.entity.Customer;
import com.capstone.exception.CustomerAlreadyExists;
import com.capstone.exception.CustomerNotFound;
import com.capstone.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer add(Customer c) {
//		return repo.save(c);
		if(repo.findById(c.getCustid()).isEmpty()) {
			
		  return repo.save(c);
		}
		else
			throw new CustomerAlreadyExists("Customer Already exists");
	}

	@Override
	public Customer find(String custid) {

		return repo.findById(custid).orElseThrow(()->new CustomerNotFound("Credentials not found"));
	}

	@Override
	public List<Customer> list() {

		return repo.findAll();
	}

	@Override
	public Customer authenticate(String custid, String password) {
			
		return repo.findByCustidAndPassword(custid, password).orElseThrow(()-> new CustomerNotFound("Credentials not found"));
	}

}
