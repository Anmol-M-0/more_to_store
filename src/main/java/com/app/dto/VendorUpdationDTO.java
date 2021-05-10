package com.app.dto;

import java.util.LinkedList;
import java.util.List;
import com.app.pojos.Address;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

public class VendorUpdationDTO {
	private Address vendorAddress;
	private List<String> strs = new LinkedList<>();
	private Vendor vendorInfo;
	private List<VendorCategory> vendorCategories;
	
	public VendorUpdationDTO() {
		super();
	}
	
	public VendorUpdationDTO(Address vendorAddress, List<String> strs, Vendor vendorInfo,
			List<VendorCategory> vendorCategories) {
		super();
		this.vendorAddress = vendorAddress;
		this.strs = strs;
		this.vendorInfo = vendorInfo;
		this.vendorCategories = vendorCategories;
	}
	public Address getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(Address vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public List<String> getStrs() {
		return strs;
	}
	public void setStrs(List<String> strs) {
		this.strs = strs;
	}
	public Vendor getVendorInfo() {
		return vendorInfo;
	}
	public void setVendorInfo(Vendor vendorInfo) {
		this.vendorInfo = vendorInfo;
	}
	public List<VendorCategory> getVendorCategories() {
		return vendorCategories;
	}
	public void setVendorCategories(List<VendorCategory> vendorCategories) {
		this.vendorCategories = vendorCategories;
	}
	
	@Override
	public String toString() {
		return "VendorUpdationDTO [vendorAddress=" + vendorAddress + ", strs=" + strs + ", vendorInfo=" + vendorInfo
				+ ", vendorCategories=" + vendorCategories + "]";
	}
	
}
