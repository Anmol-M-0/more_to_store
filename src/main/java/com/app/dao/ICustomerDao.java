package com.app.dao;

import com.app.pojos.Customer;

public interface ICustomerDao {
	String registerCustomer(Customer cust);

	Customer validateCustomer(String email, String password);
}
