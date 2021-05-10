package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.dao.ManufactureInformationRepository;
import com.app.dao.MobileRepository;

import com.app.dao.TechnicalDetailsRepository;
import com.app.dao.VendorRepository;
import com.app.pojos.Mobile;
import com.app.pojos.Product;
import com.app.pojos.Vendor;


@Transactional
@Service
public class MobileServiceImpl implements IMobileService {
	
	@Autowired
	private MobileRepository mobileRepository;
	@Autowired
	private VendorRepository vendorRepository;
	
	
	@Autowired
	private ManufactureInformationRepository manufactureInformationRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private TechnicalDetailsRepository technicalDetailsRepository;
	
	
	@Override
	public Mobile saveMobile(Mobile mobile, Vendor vendor) {
		System.out.println("in save mobile");
		
		mobile.getManufactureInformation().setManufactureLocation(addressRepository.save(mobile.getManufactureInformation().getManufactureLocation()));
		mobile.setManufactureInformation(manufactureInformationRepository.save(mobile.getManufactureInformation()));
		mobile.setTechnicalDetails(technicalDetailsRepository.save(mobile.getTechnicalDetails()));
		Mobile savedMobile = mobileRepository.save(mobile);
		Vendor transientVendor = vendorRepository.findById(vendor.getId()).get();
		System.out.println("saved mobile");
		
		System.out.println("got vendor");
		savedMobile.addVendor(transientVendor);

		System.out.println("in cls mob service repo ");
		return savedMobile;
	}
	@Override
	public List<Mobile> fetchAllMobiles(int cid,int vid) {//sub cat id and vendor id
		List<Mobile> allMobiles =  mobileRepository.fetchAllMobiles( cid, vid);
		allMobiles.forEach(i-> System.out.println(i));
		return allMobiles;
	}
	

	@Override
	public String deleteMobile(Long pid) {		
		mobileRepository.deleteById(pid);
		return "Mobile deleted";
	}

	@Override
	public Mobile getMobile(Long id) {
		Mobile mobile = mobileRepository.findById(id).orElseThrow(()-> new RuntimeException("Could not find product"));
		return mobile;
	}
	@Override
	public String toggleMobile(Long pid) {
		Product product = mobileRepository.findById(pid).orElseThrow(()-> new RuntimeException("Could not find product"));
		if(product.getStatus().equals("hide")) 
			product.setStatus("show");
		else 
			product.setStatus("hide");
		return "Product status of "+product.getName()+" Changed to "+product.getStatus();
	
	}
	


}
