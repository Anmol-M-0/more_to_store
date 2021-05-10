package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Advertise;

@Repository
public class AdvertiseDaoImp implements IAdvertiseDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public String publishAdvertise(Advertise transientAdvertise) {
		mgr.persist(transientAdvertise);
		return "advertisement is published";
	}

	@Override
	public List<Advertise> fetchAdvertisements() {
		String jpql = "select a from Advertise a";

		return mgr.createQuery(jpql, Advertise.class).getResultList();
	}

	@Override
	public Advertise fetchAdvertise(int id) {
		return mgr.find(Advertise.class, id);
	}

	@Override
	public String toggleAdvertisement(int id, String status) {
		String jpql = "update Advertise a SET a.aStatus=:status where a.id=:id";
		mgr.createQuery(jpql).setParameter("status", status).setParameter("id", id).executeUpdate();
		return "Advertise status Changed to " + status;
	}

	@Override
	public String deleteAdvertisement(Advertise aid) {
		mgr.remove(aid);
		return "Advertise is Deleted for id=" + aid.getId();
	}
	
	@Override
	public int countOfAdvertise() {
		String jpql = "select a from Advertise a";
		int count=0;
		List<Advertise> a=mgr.createQuery(jpql, Advertise.class).getResultList();
		for (@SuppressWarnings("unused") Advertise adv : a) {
			count++;
		}
		return count;
	}
}
