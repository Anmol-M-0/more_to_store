package com.app.service;

import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.Vendor;


public interface ILoginService {
	Admin validateAdmin(String email, String password);

	Vendor validateVendor(String email,String password);

	String changeVendorPassword(int id,String cpassword);

	
}
