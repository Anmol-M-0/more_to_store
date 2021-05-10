package com.app.service;

import java.util.List;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.dao.VendorCategoryRepository;
import com.app.dao.VendorRepository;
import com.app.dto.VendorRegistrationFormDto;
import com.app.dto.VendorUpdationDTO;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;



@Transactional
@Service
public class VendorServiceImpl implements IVendorService {
	
	public static final Logger logger  = LoggerFactory.getLogger(VendorServiceImpl.class);
	
	
	@Autowired
	private VendorRepository vendorRepository;

	@SuppressWarnings("unused")
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private VendorCategoryRepository vendorCategoryRepository;

	@Override
	public Vendor validateVendor(String email, String password) {
		return vendorRepository.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new RuntimeException("Error : invalid vendor credentials !!"));
	}

	@Override
	public String saveVendor(Vendor v) {

		Vendor save = vendorRepository.save(v);
		return "Vendor added with ID :" + save.getId();
	}

	@Override
	public String saveVendorRegisteration(VendorRegistrationFormDto registration) {
		System.out.println("in saveVendorRegisteration");

		Vendor vendor = registration.getVendor();

		vendor.setFullName(
				registration.getFirstName() + " " + registration.getMiddleName() + " " + registration.getLastName());

		vendor.setVendorAddress(registration.getAddress());
		vendor.setPassword("more_to_store");
		vendor.setStatus("NEW");
		vendor = vendorRepository.save(vendor);
		
		System.out.println("vendor saved successfully "+vendor);

		// persist the vendor category in the vendor category table with the transient
		// vendor set

		VendorCategory vendorCategory = registration.getVendorCategory();
		
		vendorCategory.setVendorDetails(vendor);
		
		vendorCategory = vendorCategoryRepository.save(vendorCategory);
		
		System.out.println("vendor category saved successfully "+vendorCategory);
		
//		vendor = vendorCategory.getVendorDetails();

		return "vendor registered with id "+ vendor.getId();
	}

	@Override
	public List<Vendor> fetchVendors() {
		List<Vendor> vendors = vendorRepository.findAll();
		logger.info("result of findall = {}", vendors);
		return vendors;
	}
	@Override
	public String toggleVendor(int id) {
		Vendor vendor=vendorRepository.findById(id).orElseThrow(()->new RuntimeException("error in toggle vendor, invalid id "));
		
		if(vendor.getStatus().equals("hide"))
			vendor.setStatus("show");
		else
			vendor.setStatus("hide");
		return "the status of vendor with id "+id+" changed to "+vendor.getStatus();
		
	}
	
	@Override
	public String deleteVendor(int vid) {
		vendorRepository.findById(vid);
		vendorRepository.deleteById(vid);
		return "vendor with id "+vid +"deleted successfully";
	}


	

	@Override
	public Vendor fetchVendorByID(int id) {
		Vendor vendor = vendorRepository.findById(id).orElseThrow(()->new RuntimeException("invalid id"));
		
		logger.info("found vendor: {}", vendor);
		
		return vendor;
	}

	@Override
	public String updateVendor(VendorUpdationDTO dto) {
		logger.info("updating vendor : {}",dto);
		List<VendorCategory> selectedVendorCategories = dto.getVendorCategories();
		selectedVendorCategories.forEach(svc->{
			svc.setVendorDetails(dto.getVendorInfo());
			dto.getVendorInfo().getVendorCategory().add(svc);
		});
		
		Vendor vendor = dto.getVendorInfo();
		
		Vendor transientVendor = vendorRepository.save(vendor);
		
//		Set<VendorCategory> oldCategories = transientVendor.getVendorCategory();
//		System.out.println(oldCategories);
//		Set<VendorCategory> vendorCategories = dto.getVendorCategories().stream().collect(Collectors.toSet());
//		vendorCategories.forEach(c->{
//			c.setVendorDetails(transientVendor);
//			transientVendor.getVendorCategory().add(c);
//		});
//		oldCategories.addAll(vendorCategories);
		System.out.println("old + new categories : "+transientVendor.getVendorCategory());
		vendor.setVendorAddress(dto.getVendorAddress());
		logger.info("updated vendor : {}",vendor);
		return "Vendor with id "+vendor.getId()+" updated successfully.";
	}
}
