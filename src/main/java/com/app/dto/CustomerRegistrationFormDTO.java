package com.app.dto;

import com.app.pojos.Address;
import com.app.pojos.Customer;

public class CustomerRegistrationFormDTO {
	
	private Customer customer ;
	private Address customerAddress;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public CustomerRegistrationFormDTO() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public CustomerRegistrationFormDTO(Customer customer, Address customerAddress, String firstName, String middleName,
			String lastName) {
		super();
		this.customer = customer;
		this.customerAddress = customerAddress;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "CustomerRegistrationFormDTO [customer=" + customer + ", customerAddress=" + customerAddress
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}
	
	
}
