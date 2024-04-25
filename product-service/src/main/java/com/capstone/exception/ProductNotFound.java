package com.capstone.exception;

public class ProductNotFound extends RuntimeException {
	public ProductNotFound(String message) {
		super(message);
	}
}
