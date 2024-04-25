package com.capstone.rest;
/**  
 * author: shashank;
 * version: 17
 * Cart Controller
 * includes product details and customer details
 * 
 * 
 * */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Cart;
import com.capstone.service.CartService;
import com.capstone.vo.CartTemplate;

@RestController
@CrossOrigin
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	private CartService service;

	@PostMapping(value = "/add", consumes = "application/json")
	public void add(@RequestBody Cart c) {
		service.add(c);
	}

	@DeleteMapping(value = "/delete/{cid}", produces = "application/json")
	public void delete(@PathVariable int cid) {
		service.delete(cid);
	}
	
	@GetMapping(value = "/listbycustid/{custid}", produces = "application/json")
	public List<CartTemplate> list(@PathVariable String custid) {
		return service.listByCustid(custid);
	}

}
