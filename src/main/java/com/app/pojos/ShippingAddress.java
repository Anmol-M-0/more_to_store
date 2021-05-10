package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_address_tbl")
public class ShippingAddress extends BaseEntity{
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;//one to one undirectional

	@ManyToOne
	@JoinColumn(name = "cust_details_id")
	private AdditionalDetails customerDetails;//many to one

	public ShippingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShippingAddress(Address address, AdditionalDetails customerDetails) {
		super();
		this.address = address;
		this.customerDetails = customerDetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AdditionalDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(AdditionalDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		ShippingAddress other = (ShippingAddress) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}
	
	

}
