package com.capstone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capstone.exception.ProductAlreadyExists;
import com.capstone.exception.ProductNotFound;
import com.capstone.model.Product;
import com.capstone.repo.ProductRepository;
import com.capstone.service.ProductService;
import com.capstone.service.ProductServiceImpl;

public class ProductTest {

	@Mock
	private ProductRepository repo;

	@InjectMocks
	private ProductServiceImpl service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddProductSuccess() throws ProductAlreadyExists {
		Product p = new Product(40011, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");
		when(repo.existsById(p.getId())).thenReturn(false);
		when(repo.save(p)).thenReturn(p);
		assertEquals(p, service.add(p));
	}

	@Test
	public void testFindProductSuccess() {
		Product p = new Product(40011, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");
		when(repo.findById(p.getId())).thenReturn(java.util.Optional.of(p));
		assertEquals(p, service.find(p.getId()));
	}

	@Test
	public void testFindProductFailure() {
		int id = 3232;
		when(repo.findById(id)).thenReturn(java.util.Optional.empty());
		assertThrows(ProductNotFound.class, () -> service.find(id));
	}

	@Test
	public void testListProducts() {
		Product p = new Product(40011, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");

		Product p2 = new Product(40014, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");
		List<Product> products = Arrays.asList(p, p2);

		when(repo.findAll()).thenReturn(products);

		assertEquals(products, service.list());

	}

	@Test
	public void testDeleteProduct() {
		int id = 40011;

		service.delete(id);

	}

	@Test
	public void testUpdateProductSuccess() {
		Product p = new Product(40011, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");
		when(repo.existsById(p.getId())).thenReturn(true);
		when(repo.save(p)).thenReturn(p);

		assertEquals(p, service.update(p));

	}

	@Test
	public void testUpdateProductFailure() {
		Product p = new Product(40012, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");
		int id = 21212;

		when(repo.existsById(id)).thenReturn(false);

		assertThrows(ProductNotFound.class, () -> service.update(p));

	}

	@Test
	public void testListByCategory() {
		Product p = new Product(40011, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");
		Product p2 = new Product(40012, "Gloves", "Clothes", 45.00, true, "assets/assets1.jpg");
		String category = "Electronics";

		List<Product> products = Arrays.asList(p, p2);

		when(repo.findByCategory(category)).thenReturn(products);

		assertEquals(products, service.listByCategory(category));

	}

}