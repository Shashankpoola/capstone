package com.capstone.service;

import java.util.List;

import com.capstone.entity.Cart;
import com.capstone.vo.CartTemplate;

public interface CartService {
	
	
	Cart add(Cart c);
	
	List<CartTemplate> listByCustid(String custid); 
	
	void delete(int cid);
	
	
	
	
}
