package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Description;
import com.app.pojos.Fashion;
import com.app.pojos.ManufactureInformation;
import com.app.pojos.Mobile;
import com.app.pojos.Product;
import com.app.pojos.ProductImage;
import com.app.pojos.TechnicalDetails;

@Repository
public class ProductDaoImp implements IProductDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Mobile> fetchMobiles(String brand) {
		String jpql = "select m from Mobile m where m.brand=:brand";
		return mgr.createQuery(jpql, Mobile.class).setParameter("brand", brand).getResultList();
	}

	@Override
	public Mobile fetchMobileByIdVendor(String proId) {
		Long Id = Long.parseLong(proId);
		return mgr.find(Mobile.class, Id);
	}

	@Override
	public String addImage(ProductImage transientpImage) {
		mgr.persist(transientpImage);
		return "Image is Added At Id " + transientpImage.getId();
	}

	@Override
	public List<ProductImage> fetchProductImage(Product p) {

		String jpql = "select pI from ProductImage pI where pI.product=:p";
		return mgr.createQuery(jpql, ProductImage.class).setParameter("p", p).getResultList();
	}

	@Override
	public ProductImage fetchProductImage(int id) {
		return mgr.find(ProductImage.class, id);
	}

	@Override
	public String deleteImage(String Iid) {

		Product product = mgr.find(Mobile.class, Long.parseLong(Iid));
		
			String jpql = "select p from ProductImage p where p.product=:prod";
			ProductImage proImage = mgr.createQuery(jpql, ProductImage.class).setParameter("prod", product)
					.getSingleResult();
			mgr.remove(proImage);
			return "Image is deleted ";
		
	}

	@Override
	public String uploadMainImage(Long id, byte[] imageFile) {
		Product p = mgr.find(Mobile.class, id);
		p.setpImage(imageFile);
		return "Image is uploaded" + p.getId();
	}

	@Override
	public TechnicalDetails fetchTechnicalDetails(int id) {

		return mgr.find(TechnicalDetails.class, id);
	}

	@Override
	public ManufactureInformation fetchManufactureInformation(int id) {

		return mgr.find(ManufactureInformation.class, id);
	}

	@Override
	public Description fetchDescription(int id) {

		return mgr.find(Description.class, id);
	}

	@Override
	public Address fetchMfgAddress(int id) {

		return mgr.find(Address.class, id);
	}

	@Override
	public String updateProductTable(String pid, String stock, String price, String offer) {
		Long id = Long.parseLong(pid);
		Product p = (Mobile) mgr.find(Mobile.class, id);
		p.setStock(Integer.parseInt(stock));
		p.setPrice(Double.parseDouble(price));
		p.setOffer(Double.parseDouble(offer));
		return "Update Done ";
	}

	@Override
	public String updateManufactureInfo(int mid, String warrenty, String manufactureInfo) {
		ManufactureInformation mfgInfo = mgr.find(ManufactureInformation.class, mid);
		mfgInfo.setManufactureInfo(manufactureInfo);
		mfgInfo.setWarrenty(Integer.parseInt(warrenty));
		return "update done";
	}

	@Override
	public String updateAddress(int aid, String city, String state, String district, String pincode, String country,
			String addressLine1, String addressLine2, String postOffice) {
		Address address = mgr.find(Address.class, aid);
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setCity(city);
		address.setCountry(country);
		address.setDistrict(district);
		address.setPincode(Integer.parseInt(pincode));
		address.setPostOffice(postOffice);
		address.setState(state);
		return null;
	}

	@Override
	public String updateDescription(int did, String brief) {
		Description desc = mgr.find(Description.class, did);
		desc.setBrief(brief);
		return null;
	}

	@Override
	public String UpdateTechnicalDetails(int tid, String modelNo, String os, String ram, String dimensions,
			String batteryCapacity, String color, String connectivity, String display, String camera, String weight,
			String multimedia, String operatingFrequency, String resolution) {
		TechnicalDetails techD = mgr.find(TechnicalDetails.class, tid);
		techD.setModelNo(modelNo);
		techD.setOperatingFrequency(operatingFrequency);
		techD.setBatteryCapacity(Double.parseDouble(batteryCapacity));
		techD.setRam(Double.parseDouble(ram));
		techD.setColor(color);
		techD.setConnectivity(connectivity);
		techD.setDisplay(display);
		techD.setDimensions(dimensions);
		techD.setMultimedia(multimedia);
		techD.setResolution(resolution);
		techD.setWeight(Double.parseDouble(weight));
		techD.setCamera(camera);

		return null;
	}

	@Override
	public List<Fashion> fetchFashions(String subCTitle) {
		String jpql = "select f from Fashion f where f.brand=:brand";
		return mgr.createQuery(jpql, Fashion.class).setParameter("brand", subCTitle).getResultList();
	}

	@Override
	public List<ProductImage> getImages(Long pid) {
		Product p = mgr.find(Mobile.class, pid);
		String jpql = "select pi from ProductImage pi.product=:p";
		return mgr.createQuery(jpql, ProductImage.class).setParameter("p", p).getResultList();
	}

}
