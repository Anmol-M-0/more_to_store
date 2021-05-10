package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Cart;
import com.app.pojos.Customer;

@Repository
public class CustomerDaoImp implements ICustomerDao {

	@Autowired
	private EntityManager mgr;
	@Override
	public String registerCustomer(Customer cust) {
		mgr.persist(cust);
		Cart c=new Cart();
		mgr.persist(c);
		System.out.println("cart : "+c.getId());
		return "Your Registration is Done Please Login ";
	}

	@Override
	public Customer validateCustomer(String email, String password) {
		String jpql = "select c from Customer c where c.email=:email and c.password=:password";
		Customer cust=mgr.createQuery(jpql, Customer.class).setParameter("email", email).setParameter("password",password).getSingleResult();
		return cust;
	}

}
