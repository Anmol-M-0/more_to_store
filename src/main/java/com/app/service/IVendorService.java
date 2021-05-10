package com.app.service;

import java.util.List;

import com.app.dto.VendorRegistrationFormDto;
import com.app.dto.VendorUpdationDTO;
import com.app.pojos.Vendor;

public interface IVendorService {
	
	Vendor validateVendor(String email,String password);
	String saveVendor(Vendor v);
	String saveVendorRegisteration(VendorRegistrationFormDto registration);
	
	List<Vendor> fetchVendors();
	String updateVendor(VendorUpdationDTO vendor);
	String toggleVendor(int id);
	String deleteVendor(int vid);
	Vendor fetchVendorByID(int id);
}
