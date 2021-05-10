package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "addresses_tbl")
public class Address extends BaseEntity{//pl validation
	@Column(name = "address_1")
//	@Length(max = 500)
	private String addressLine1;
//	@Length(max = 500)
	@Column(name = "address_2")
	private String addressLine2;
//	@Length(max = 20)
	@Column(length = 20)
	private String city;
//	@Length(max = 20)
	@Column(length = 20)
	private String district;
	@Column(length = 20)
//	@Length(max = 20)
	private String state;
//	@Length(max = 200)
	private String postOffice;
//	@Min(value = 99999)
	private int pincode;
//	@Length(max = 20)
	@Column(length = 20)
	private String country;
	
	public Address() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Address(String addressLine1, String addressLine2, String city, String district, String state,
			String postOffice, int pincode, String country) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.district = district;
		this.state = state;
		this.postOffice = postOffice;
		this.pincode = pincode;
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", district=" + district + ", state=" + state + ", postOffice=" + postOffice + ", pincode=" + pincode
				+ ", country=" + country + "]";
	}

	

}
