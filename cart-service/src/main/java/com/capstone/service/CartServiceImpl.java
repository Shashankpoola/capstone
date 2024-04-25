package com.capstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capstone.entity.Cart;
import com.capstone.model.Product;
import com.capstone.repo.CartRepository;
import com.capstone.vo.CartTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository repo;

	@Autowired
	private RestTemplate rest;

	@Override
	public Cart add(Cart c) {
		return repo.save(c);
	}

	@Override
	public List<CartTemplate> listByCustid(String custid) {
		List<Cart> carts = repo.findByCustid(custid);
        ResponseEntity<List<Product>> productResponse = rest.exchange(
            "http://localhost:9001/product/list",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Product>>() {}
            );
        List<Product> products = productResponse.getBody();
        List<CartTemplate> items = new ArrayList<CartTemplate>();
        for (Cart c : carts) {
            CartTemplate ct = new CartTemplate();
            ct.setCart(c);
            Product cartProduct = products.stream().filter(p -> p.getId() == c.getId()).findFirst().orElse(null);
            ct.setProduct(cartProduct);
            items.add(ct);
        }
		return items;
	}

	@Override
	public void delete(int cid) {
		repo.deleteById(cid);
	}

}
