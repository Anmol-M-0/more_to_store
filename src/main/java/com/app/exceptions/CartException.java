package com.app.exceptions;

@SuppressWarnings("serial")
public class CartException extends RuntimeException {
	public CartException() {
	}

	public CartException(String msg) {
		super(msg);
	}
}
