package com.app.dao;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Description;
import com.app.pojos.Fashion;
import com.app.pojos.ManufactureInformation;
import com.app.pojos.Mobile;
import com.app.pojos.Product;
import com.app.pojos.ProductImage;
import com.app.pojos.TechnicalDetails;

public interface IProductDao {

	List<Mobile> fetchMobiles(String brand);

	Mobile fetchMobileByIdVendor(String proId);

	String addImage(ProductImage transientpImage);

	List<ProductImage> fetchProductImage(Product p);

	String deleteImage(String Iid);

	ProductImage fetchProductImage(int id);

	String uploadMainImage(Long id, byte[] imageFile);

	TechnicalDetails fetchTechnicalDetails(int id);

	ManufactureInformation fetchManufactureInformation(int id);

	Description fetchDescription(int id);

	Address fetchMfgAddress(int id);

	String updateProductTable(String pid, String stock, String price, String offer);

	String updateManufactureInfo(int mid, String warrenty, String manufactureInfo);

	String updateAddress(int aid, String city, String state, String district, String pincode, String country,
			String addressLine1, String addressLine2, String postOffice);

	String updateDescription(int did, String brief);

	String UpdateTechnicalDetails(int tid, String modelNo, String os, String ram, String dimensions,
			String batteryCapacity, String color, String connectivity, String display, String camera, String weight,
			String multimedia, String operatingFrequency, String resolution);

	List<Fashion> fetchFashions(String subCTitle);

	List<ProductImage> getImages(Long pid);
}
