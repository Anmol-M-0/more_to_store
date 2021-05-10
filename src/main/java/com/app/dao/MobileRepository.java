package com.app.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Mobile;


@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {

	@Query(value = "select * from mobile m  INNER JOIN  vendor_category_tbl c On m.vendor_category_id=c.id where c.id=:cid and c.vendor_id= :vid", nativeQuery = true)
	List<Mobile> fetchAllMobiles(int cid, int vid);
	
	@Query(nativeQuery = true, value = "select * from mobile where id in :stringIds")
	Set<Mobile> fetchCustomerMobiles(String stringIds);
}
