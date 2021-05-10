package com.app.utils;

import com.app.dto.VendorUpdationDTO;
import com.app.pojos.Vendor;

public interface VendorUtils {

	static void fetchVendor(VendorUpdationDTO vendor, Vendor vendorInformation) {
		vendorInformation.setFullName(vendor.getVendorInfo().getFullName());
		vendorInformation.setShopName(vendor.getVendorInfo().getShopName());
		vendorInformation.setRegNo(vendor.getVendorInfo().getRegNo());
		vendorInformation.getVendorAddress().setCity(vendor.getVendorAddress().getCity());
		vendorInformation.getVendorAddress().setState(vendor.getVendorAddress().getState());
		vendorInformation.getVendorAddress().setDistrict(vendor.getVendorAddress().getDistrict());
		vendorInformation.getVendorAddress().setAddressLine1(vendor.getVendorAddress().getAddressLine1());
		vendorInformation.getVendorAddress().setAddressLine2(vendor.getVendorAddress().getAddressLine2());
		vendorInformation.getVendorAddress().setPostOffice(vendor.getVendorAddress().getPostOffice());
		vendorInformation.getVendorAddress().setPincode(vendor.getVendorAddress().getPincode());
		vendorInformation.getVendorAddress().setCountry(vendor.getVendorAddress().getCountry());
		vendor.setVendorInfo(vendorInformation);

	}

}
