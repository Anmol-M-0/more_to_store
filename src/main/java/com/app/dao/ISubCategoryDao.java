package com.app.dao;

import java.util.List;
import java.util.stream.Stream;

import com.app.pojos.Category;
import com.app.pojos.SubCategory;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

public interface ISubCategoryDao {

	String createSubCategory(Category c, String sCTitle, String status);

	List<SubCategory> fetchSubCategories();

	SubCategory fetchSubCategory(int id);

	String toggleSubCategory(int id, String status);
	
	String deleteCategory(SubCategory sid);
	
	int countOfSubCategory();
	
	List<VendorCategory> fetchVendorCategory(Vendor v);

	SubCategory fetchSubCategory(String subCategory);
	
	List<SubCategory> fetSubCategoryForNav(Category catId);

	List<SubCategory> fetchVendorSubCategories(int id);
}
