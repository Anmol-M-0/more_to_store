package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Modifying
	@Query(nativeQuery = true, value = "update addresses_tbl set address_1= :a1 , address_2=:a2 , city= :city , state= :state, district= :district, post_office= :post, pincode =:pin ,country=:country where id=:id")
	void updateAddress(@Param(value = "a1") String addressLine1,@Param(value = "a2") String addressLine2,@Param(value = "city") String city,@Param(value = "state") String state,@Param(value = "district") String district,
			@Param(value = "post") String postOffice,@Param(value = "pin") int pincode,@Param(value = "country") String country, Integer id);

	

}
