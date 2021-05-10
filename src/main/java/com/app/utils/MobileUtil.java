package com.app.utils;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.MobileRegisterationFormDTO;
import com.app.pojos.ManufactureInformation;
import com.app.pojos.Mobile;
import com.app.pojos.Product;
import com.app.pojos.TechnicalDetails;
import com.app.pojos.VendorCategory;


public interface MobileUtil {

	static Mobile getMobile(MobileRegisterationFormDTO dto, List<VendorCategory> vendorCategory, String subCategory) {
		Mobile mobile = new Mobile();
		mobile.setTitle(dto.getTitle());
		mobile.setBrand(dto.getBrand());
		mobile.setDateAdded(LocalDate.now());
		mobile.setDescription(dto.getDescription());
		mobile.setManufactureInformation(new ManufactureInformation());
		mobile.getManufactureInformation().setManufactureDate(dto.getManufactureDate());
		mobile.getManufactureInformation().setManufactureInfo(dto.getManufactureInfo());
		mobile.getManufactureInformation().setManufactureLocation(dto.getManufactureLocation());
		mobile.getManufactureInformation().getManufactureLocation().setPincode(Integer.parseInt(dto.getPincode()));
		mobile.getManufactureInformation().setWarrenty(Integer.parseInt(dto.getWarrenty()));
		mobile.setName(dto.getName());
//		mobile.setOffer(Double.parseDouble(dto.getOffer())); dont set offer now
		mobile.setPrice(Double.parseDouble(dto.getPrice()));
		VendorCategory productCategory = vendorCategory.stream().filter(i->i.getCategoryTitle().equals(subCategory)).findFirst().get();
		mobile.setProductCategory(productCategory);
		mobile.setStatus("NEW");
		mobile.setStock(Integer.parseInt(dto.getStock()));
		mobile.setTechnicalDetails(new TechnicalDetails());
		mobile.getTechnicalDetails().setBatteryCapacity(Double.parseDouble(dto.getBatteryCapacity()));
		mobile.getTechnicalDetails().setCamera(dto.getCamera());
		mobile.getTechnicalDetails().setColor(dto.getColor());
		mobile.getTechnicalDetails().setConnectivity(dto.getConnectivity());
		mobile.getTechnicalDetails().setDimensions(dto.getDimensions());
		mobile.getTechnicalDetails().setDisplay(dto.getDisplay());
		mobile.getTechnicalDetails().setModelNo(dto.getModelNo());
		mobile.getTechnicalDetails().setMultimedia(dto.getMultimedia());
		mobile.getTechnicalDetails().setOperatingFrequency(dto.getOperatingFrequency());
		mobile.getTechnicalDetails().setOs(dto.getOs());
		mobile.getTechnicalDetails().setRam(Double.parseDouble(dto.getRam()));
		mobile.getTechnicalDetails().setResolution(dto.getResolution());
		mobile.getTechnicalDetails().setWeight(Double.parseDouble(dto.getWeight()));
		return mobile;
	}
}
