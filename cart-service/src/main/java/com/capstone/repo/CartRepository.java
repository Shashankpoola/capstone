package com.capstone.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.Cart;
import com.capstone.vo.CartTemplate;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	
	List<Cart> findByCustid(String custid);
	
	
	

}
