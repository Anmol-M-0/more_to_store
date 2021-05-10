package com.app.dto;

import com.app.pojos.Address;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

public class VendorRegistrationFormDto {
	private Vendor vendor;
	private Address address;//eg : registeration.address.addressLine1
	private VendorCategory vendorCategory;
	private String firstName;//
	private String middleName;//
	private String lastName;//
//	//changes -> in vendor_registeration.jsp add addln1, addln2
	public VendorRegistrationFormDto() {
		super();
	}
	public VendorRegistrationFormDto(Vendor vendor, Address address, VendorCategory vendorCategory, String firstName,
			String middleName, String lastName) {
		super();
		this.vendor = vendor;
		this.address = address;
		this.vendorCategory = vendorCategory;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public VendorCategory getVendorCategory() {
		return vendorCategory;
	}
	public void setVendorCategory(VendorCategory vendorCategory) {
		this.vendorCategory = vendorCategory;
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
		return "VendorRegisterationFormDto [firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + "]";
	}
	
	
	
	
	

}
