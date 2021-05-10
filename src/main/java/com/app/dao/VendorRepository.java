package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	
	Optional<Vendor> findByEmailAndPassword(String email, String password);
	//select v from Vendor v where v.ema ... v.pass ...;
	//returns the number of rows affectes
	@Modifying( clearAutomatically = true, flushAutomatically = true )
	@Query("update Vendor v set v.fullName=:fullName, v.password=:password, v.shopName=:shopName, "
			+ "v.vendorCategory=:vendorCategory, v.vendorAddress=:vendorAddress where v.id=:id")
	int updateVendor(@Param("id") int id, @Param("fullName") String fullName, @Param("password")String password, @Param("shopName") String shopName,
			@Param("vendorCategory") List<VendorCategory> vendorCategory,@Param("vendorAddress") Address vendorAddress);
	
//	@Modifying
//	@Query("update Vendor v set v.")
	
}
