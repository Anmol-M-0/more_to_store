package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.IProductDao;
import com.app.dao.ProductRepository;
import com.app.exceptions.ProductNotFoundException;
import com.app.pojos.Address;
import com.app.pojos.Description;
import com.app.pojos.Fashion;
import com.app.pojos.ManufactureInformation;
import com.app.pojos.Mobile;
import com.app.pojos.Product;
import com.app.pojos.ProductImage;
import com.app.pojos.TechnicalDetails;


@Service
@Transactional
public class ProductServiceImp implements IProductService {

	@Autowired
	private IProductDao productDao;
	@Autowired 
	private ProductRepository productRepository;

	@Override
	public List<Mobile> fetchMobiles(String brand) {
		return productDao.fetchMobiles(brand);
	}
	@Override
	public Mobile fetchMobile(String proId) {
		
		return productDao.fetchMobileByIdVendor(proId);
	}
	@Override
	public String addImage(ProductImage transientpImage) {
		
		return productDao.addImage(transientpImage);
	}
	@Override
	public List<ProductImage> fetchProductImage(Product p) {
		
		return productDao.fetchProductImage(p);
	}
	@Override
	public String deleteImage(String Iid) {
		
		return productDao.deleteImage(Iid);
	}
	@Override
	public String uploadMainImage(Long id, byte[] imageFile) {
		
		return productDao.uploadMainImage(id,imageFile);
	}
	@Override
	public TechnicalDetails fetchTechnicalDetails(int id) {
		return productDao.fetchTechnicalDetails(id);
	}
	@Override
	public ManufactureInformation fetchManufactureInformation(int id) {
		return productDao.fetchManufactureInformation(id);
	}
	@Override
	public Description fetchDescription(int id) {
		return productDao.fetchDescription(id);
	}
	@Override
	public Address fetchMfgAddress(int id) {
		return productDao.fetchMfgAddress(id);
	}
	
	@Override
	public String updateProductTable(String pid, String stock,String price,String offer) {
		
		return productDao.updateProductTable(pid, stock, price, offer);
	}
	@Override
	public String updateManufactureInfo(int mid, String warrenty, String manufactureInfo) {
		
		return productDao.updateManufactureInfo(mid,warrenty,manufactureInfo);
	}
	@Override
	public String updateAddress(int aid, String city, String state, String district, String pincode, String country,
			String addressLine1, String addressLine2, String postOffice) {
		
		return productDao.updateAddress(aid,city,state,district,pincode,country,addressLine1,addressLine2,postOffice);
	}
	@Override
	public String updateDescription(int did, String brief) {
		
		return productDao.updateDescription(did,brief);
	}
	@Override
	public String UpdateTechnicalDetails(int tid, String modelNo, String os, String ram, String dimensions,
			String batteryCapacity, String color, String connectivity, String display, String camera, String weight,
			String multimedia, String operatingFrequency, String resolution) {
		
		return productDao.UpdateTechnicalDetails(tid,modelNo, os, ram, dimensions, batteryCapacity, color, connectivity, display, camera, weight, multimedia, operatingFrequency, resolution);
	}
	@Override
	public List<Fashion> fetchFashions(String subCTitle) {
			return productDao.fetchFashions(subCTitle);
	}
	@Override
	public String fetchCategoryTitle(int sid) {//vendor_category
		String title=productRepository.getTitle(sid); //getting title of vc
		int subId=productRepository.fetchSubCategoryId(title); //from title getting sub category id
		return productRepository.fetchMainCategory(subId).orElseThrow(()-> new ProductNotFoundException("main category not found"));
	}
	@Override
	public List<ProductImage> getImages(Long pid) {
		// TODO Auto-generated method stub
		return productDao.getImages(pid);
	}
	@Override
	public int deleteImage(int proId) {
		// TODO Auto-generated method stub
		return productRepository.deleteMobileImage(proId);
	}
	

}
