package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILoginDao;
import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.Vendor;


@Service
@Transactional
public class LoginServiceImp implements ILoginService {

	@Autowired
	private ILoginDao loginDao;

	@Override
	public Admin validateAdmin(String email, String password) {
		return loginDao.validateAdmin(email, password);
	}

	@Override
	public Vendor validateVendor(String email, String password) {
		System.out.println("in validate vendor service");
		return loginDao.validateVendor(email,password);
	}

	@Override
	public String changeVendorPassword(int id, String cpassword) {
		return loginDao.changeVendorPassword(id, cpassword);
	}

	

	
}
