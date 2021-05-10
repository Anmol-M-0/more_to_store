package com.app.service;

import java.util.List;

import com.app.dto.FashionRegistrationFormDto;
import com.app.pojos.Fashion;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

public interface IFashionService {

	String saveFashionItem(FashionRegistrationFormDto fashionDto, List<VendorCategory> vendorCategory, String subCategory,Vendor vendor, byte[] imageFile);
	List<Fashion> fetchAllFashionProducts(int cid,int vid);

	String deleteFashion(Long pid);
	
	String toogleFashion(Long pid);
	
	Fashion getFashion(Long pid);
}
