package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Advertise;
import com.app.pojos.Banner;

@Repository
public class BannerDaoImpl implements IBannerDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public String addBanner(Banner transientBanner) {
		mgr.persist(transientBanner);
		return "Banner added with Id : "+transientBanner.getId();
	}

	@Override
	public List<Banner> fetchAllBanner() {
		String jpql = "select c from Banner c";
		return mgr.createQuery(jpql, Banner.class).getResultList();
	}

	@Override
	public Banner fetchBanner(int id) {	
		return mgr.find(Banner.class, id);
	}

	@Override
	public String toggleBanner(int id, String status) {
		String jpql = "update Banner b SET b.bannerStatus=:status where b.id=:id";
		mgr.createQuery(jpql).setParameter("status", status).setParameter("id", id).executeUpdate();
		return "Banner status Changed to " + status;
	}

	@Override
	public String deleteBanner(Banner id) {
		mgr.remove(id);
		return "Banner is Deleted for id=" + id.getId();
	}

	@Override
	public int countOfBanner() {
		String jpql = "select a from Banner a";
		int count=0;
		List<Banner> a=mgr.createQuery(jpql, Banner.class).getResultList();
		for (@SuppressWarnings("unused") Banner ban : a) {
			count++;
		}
		return count;
	}

	@Override
	public List<Banner> fetchCustomerBanner() {
		String jpql="select b from Banner b where b.bannerStatus='show'";
		return mgr.createQuery(jpql, Banner.class).getResultList();
	}
	@Override
	public List<Advertise> fetchCustomerAdvertise() {
		String jpql="select b from Advertise b where b.aStatus='show'";
		return mgr.createQuery(jpql, Advertise.class).getResultList();
	}
}
