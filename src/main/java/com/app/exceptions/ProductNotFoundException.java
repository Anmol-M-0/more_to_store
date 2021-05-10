package com.app.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException() {
	}
	
	public ProductNotFoundException(String msg) {
		super(msg);
	}
	
}
