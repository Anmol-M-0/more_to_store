package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select m.category_title from main_categories m inner join sub_categories s ON m.id=s.category_id where s.id=:sid", nativeQuery = true)
	Optional<String> fetchMainCategory(int sid);

	@Query(value = "select id from sub_categories where sub_category_title=:title ", nativeQuery = true)
	int fetchSubCategoryId(String title);

	@Query(value = "select category_title from vendor_category_tbl where id=:sid ", nativeQuery = true)
	String getTitle(int sid);

	@Modifying
	@Query(value = "delete from product_images_tbl where product_id = :pid",nativeQuery = true)
	int deleteMobileImage(@Param("pid")int proId);

}
