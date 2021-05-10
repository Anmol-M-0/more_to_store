package com.app.dao;

import com.app.pojos.Admin;
import com.app.pojos.Vendor;

public interface ILoginDao {

	Admin validateAdmin(String email, String password);

	Vendor validateVendor(String email,String password);
	
	String changeVendorPassword(int id,String cpassword);

	Vendor fetchVendorById(Integer id);

	
}
