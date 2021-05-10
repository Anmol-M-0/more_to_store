package com.app.service;

import java.util.List;

import com.app.pojos.Advertise;
import com.app.pojos.Banner;

public interface IBannerService {

	// add banner
	String addBanner(Banner transientBanner);

	// fetch all banner
	List<Banner> fetchAllBanner();

	// fetch specific banner
	Banner fetchBanner(int id);

	// toggle Banner
	String toggleBanner(int id);

	// delete banner
	String deleteBanner(int id);

	int countOfBanner();

	List<Banner> fetchCustomerBanner();

	List<Advertise> fetchCustomerAdvertise();
}
