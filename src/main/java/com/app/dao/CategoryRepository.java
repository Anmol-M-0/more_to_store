package com.app.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Category;
import com.app.pojos.SubCategory;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Optional<Category> findBycTitle(String cTitle);
	
	@Query(value = "select c.cImage from Category c where c.id=:cid")
	Optional<byte[]> fetchImg(@Param("cid") int cid);
	@Query(nativeQuery = true, value = "select * from sub_categories where sub_category_title in (select category_title from vendor_category_tbl where vendor_id = :vid);")
	Set<SubCategory> fetchVendorSubCategories(@Param(value = "vid")Integer id);
	
	}
