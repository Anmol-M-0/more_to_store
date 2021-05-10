package com.app.service;

import java.util.List;

import com.app.pojos.Advertise;

public interface IAdvertiseService {
	String publishAdvertise(Advertise transientAdvertise);

	List<Advertise> fetchAdvertisements();

	String toggleAdvertise(int id);

	String deleteAdvertise(int aid);
	int countOfAdvertise();
}
