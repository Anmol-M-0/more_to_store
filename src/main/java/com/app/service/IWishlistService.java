package com.app.service;

import com.app.pojos.Customer;
import com.app.pojos.Product;

public interface IWishlistService {
	
	String moveToCart(Long pid, Customer customer);

	String removeItemFromWishList(Long pid, Customer customer);

	Product getProduct(Long pid);

	String addToWishList(Long pid, Customer customer);

}
