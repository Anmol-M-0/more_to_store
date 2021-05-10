package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Fashion;

@Repository
public interface FashionRepository extends JpaRepository<Fashion,Long >{

	@Query(value = "select *from fashion f inner join vendor_category_tbl c On f.vendor_category_id=c.id where c.id=:cid and c.vendor_id=:vid", nativeQuery = true)
	List<Fashion> fetchAllFashions(int cid, int vid);
	
}
