package com.app.dao;

import java.util.List;
import com.app.pojos.Advertise;

public interface IAdvertiseDao {

	String publishAdvertise(Advertise transientAdvertise);

	List<Advertise> fetchAdvertisements();

	Advertise fetchAdvertise(int id);

	String toggleAdvertisement(int id, String status);

	String deleteAdvertisement(Advertise aid);

	int countOfAdvertise();
}
