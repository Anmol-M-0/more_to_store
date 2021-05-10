package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends BaseEntity {
	@Column(length = 50)
	private String name;
	@Column(length = 20, unique = true)
	private String email;// compulsary unique
	@Column(length = 20)
	private String password;
	@Column(length = 13, unique = true)
	private String mobileNo;
	/*
	 * the fetch type of one to one is eager by default but we have taken it as lazy over here for performance
	 * reasons. whenever you want these details you will have to take a few extra steps otherwise you wil get 
	 * lazy initialization exception
	 */
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cart_id")
	private Cart cart;// one to one
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name= "wishlist_id")
	private Wishlist wishlist;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Order> orders = new HashSet<>();//
	
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "addn_details_id")
	private AdditionalDetails additionalDetails;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Customer(String name, String email, String password, String mobileNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}


	public Customer(String name, String email, String password, String mobileNo, Cart cart, Wishlist wishlist,
			Set<Order> orders, AdditionalDetails additionalDetails) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.cart = cart;
		this.wishlist = wishlist;
		this.orders = orders;
		this.additionalDetails = additionalDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public AdditionalDetails getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(AdditionalDetails additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	public void addOrder(Order order) {
		order.setCustomer(this);
		this.orders.add(order);
	}
	
	public void removeOrder(Order order) {
		this.orders.remove(order);
		order.setCustomer(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", password=" + password + ", mobileNo=" + mobileNo
				+ ", customerId=" + getId() + "]";
	}


}
