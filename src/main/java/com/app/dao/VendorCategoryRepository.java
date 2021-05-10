package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.VendorCategory;
@Repository
public interface VendorCategoryRepository extends JpaRepository<VendorCategory, Integer> {

}
