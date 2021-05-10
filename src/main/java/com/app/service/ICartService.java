package com.app.service;

import java.util.Set;

import com.app.pojos.Customer;
import com.app.pojos.Mobile;

public interface ICartService {

	String addToCart(Long pid, Customer customer);

	String increaseCartitemQtyByOne(Long pid, Customer customer);

	String increaseCartitemQty(Long pid, Customer customer, int incr);

	String setCartitemQty(Long pid, Customer customer, int quantity);

	String setCartitemQtyToOne(Long pid, Customer customer);

	String decreaseCartitemQuantity(Long pid, Customer customer, int decr);

	String decreaseCartitemQtyByOne(Long pid, Customer customer);

	String saveForLater(Long pid, Customer customer);
	
	String removeFromCart(Long pid, Customer customer);

	void deleteCart(Customer customer);

	
	

}
