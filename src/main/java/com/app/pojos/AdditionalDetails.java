package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class AdditionalDetails extends BaseEntity {
	//address to be added during signup
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_addr_id")
	private Address customerAddress;
	//these get added as customer creates more orders to different addresses
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private Set<ShippingAddress> shippingAddresses = new HashSet<>();
		
	@OneToMany(mappedBy = "additionalDetails", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PaymentMode> paymentModes = new HashSet<>();//history of customer payment modes/details, one to many

	public AdditionalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdditionalDetails(Address customerAddress, Set<ShippingAddress> shippingAddresses,
			Set<PaymentMode> paymentModes) {
		super();
		this.customerAddress = customerAddress;
		this.shippingAddresses = shippingAddresses;
		this.paymentModes = paymentModes;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Set<ShippingAddress> getShippingAddresses() {
		return shippingAddresses;
	}

	public void setShippingAddresses(Set<ShippingAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}


	public Set<PaymentMode> getPaymentModes() {
		return paymentModes;
	}

	public void setPaymentModes(Set<PaymentMode> paymentModes) {
		this.paymentModes = paymentModes;
	}

	@Override
	public String toString() {
		return "AdditionalDetails [customerAddress=" + customerAddress + "]";
	}
	
	public void addShippingAddress(ShippingAddress s) {
		this.shippingAddresses.add(s);	
		s.setCustomerDetails(this);
	}
	public void removeShippingAddress(ShippingAddress s) {
		this.shippingAddresses.remove(s);
		s.setCustomerDetails(null);
	}
	
}
