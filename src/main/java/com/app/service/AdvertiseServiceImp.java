package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdvertiseDaoImp;
import com.app.dao.IAdvertiseDao;
import com.app.pojos.Advertise;

@Service
@Transactional
public class AdvertiseServiceImp implements IAdvertiseService {

	@Autowired
	private IAdvertiseDao advertiseDao;
	
	
	
	@Override
	public String publishAdvertise(Advertise transientAdvertise) {
		return advertiseDao.publishAdvertise(transientAdvertise);
	}

	@Override
	public List<Advertise> fetchAdvertisements() {
		return advertiseDao.fetchAdvertisements();
	}

	@Override
	public String toggleAdvertise(int id) {
		Advertise a = advertiseDao.fetchAdvertise(id);
		if (a.getaStatus().equals("Hide"))
			return advertiseDao.toggleAdvertisement(a.getId(), "Show");
		else
			return advertiseDao.toggleAdvertisement(a.getId(), "Hide");
	}

	@Override
	public String deleteAdvertise(int aid) {
		Advertise a = advertiseDao.fetchAdvertise(aid);
		return advertiseDao.deleteAdvertisement(a);
	}
	
	@Override
	public int countOfAdvertise() {
		
		return advertiseDao.countOfAdvertise();
	}

}
