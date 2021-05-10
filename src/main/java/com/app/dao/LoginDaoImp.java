package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Vendor;

@Repository
public class LoginDaoImp implements ILoginDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public Admin validateAdmin(String email, String password) {
		String jpql = "select a from Admin a where a.email=:email and a.password=:password";
		Admin admin = mgr.createQuery(jpql, Admin.class).setParameter("email", email).setParameter("password", password)
				.getSingleResult();
		return admin;
	}

	@Override
	public Vendor validateVendor(String email, String password) {
		System.out.println("in validate vendor Dao");
		String jpql = "select v from Vendor v where v.email=:email and v.password=:password";
		Vendor vendor = mgr.createQuery(jpql, Vendor.class).setParameter("email", email).setParameter("password", password)
				.getSingleResult();
		System.out.println("vendor details "+vendor);
		return vendor;
	}

	@Override
	public String changeVendorPassword(int id, String cpassword) {
		String jpql="update Vendor v set v.password=:password,v.status=:status where v.id=:id";
		String status="hide";
		int result =mgr.createQuery(jpql).setParameter("password", cpassword).setParameter("status", status).setParameter("id", id).executeUpdate();
		if(result == 1)
			return "password is Changed";
		return "password is not Changed";
	}

	@Override
	public Vendor fetchVendorById(Integer id) {
		
		return mgr.find(Vendor.class, id);
	}

	

	

}
