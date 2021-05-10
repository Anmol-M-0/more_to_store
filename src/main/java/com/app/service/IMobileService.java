package com.app.service;

import java.util.List;

import com.app.pojos.Mobile;
import com.app.pojos.Vendor;

public interface IMobileService {

	Mobile saveMobile(Mobile mobile, Vendor vendorDetails);
	List<Mobile> fetchAllMobiles(int cid,int vid);
	String deleteMobile(Long pid);
	Mobile getMobile(Long id);
	String toggleMobile(Long pid);
	
}
