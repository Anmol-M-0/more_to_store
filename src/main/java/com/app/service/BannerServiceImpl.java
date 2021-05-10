package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IBannerDao;
import com.app.pojos.Advertise;
import com.app.pojos.Banner;

@Service
@Transactional
public class BannerServiceImpl implements IBannerService {
	@Autowired
	private IBannerDao bannerDao;

	@Override
	public String addBanner(Banner transientCategory) {
		return bannerDao.addBanner(transientCategory);
	}

	@Override
	public List<Banner> fetchAllBanner() {
		return bannerDao.fetchAllBanner();
	}

	@Override
	public Banner fetchBanner(int id) {
		Banner b = bannerDao.fetchBanner(id);
		return b;
	}

	@Override
	public String toggleBanner(int id) {
		Banner banner = bannerDao.fetchBanner(id);
		if (banner.getBannerStatus().equals("hide"))
			return bannerDao.toggleBanner(banner.getId(), "show");
		else
			return bannerDao.toggleBanner(banner.getId(), "hide");
	}

	@Override
	public String deleteBanner(int id) {
		Banner b = bannerDao.fetchBanner(id);
		return bannerDao.deleteBanner(b);
	}

	@Override
	public int countOfBanner() {
		
		return bannerDao.countOfBanner();
	}

	@Override
	public List<Banner> fetchCustomerBanner() {
	
		return bannerDao.fetchCustomerBanner();
	}
	@Override
	public List<Advertise> fetchCustomerAdvertise() {
		// TODO Auto-generated method stub
		return bannerDao.fetchCustomerAdvertise();
	}
}
