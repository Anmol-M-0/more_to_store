package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.pojos.SubCategory;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

public interface ISubCategoryService {

	String createNewSubCategory(int cid, String subTitle);

	List<SubCategory> fetchSubCategories();

	String toggleSubCategory(int id);

	String deleteCategory(int sid);

	int countOfSubCategory();
	
	List<VendorCategory> fetchVendorCategory(Vendor v);

	SubCategory fetchSubCategory(int subCId);
	
	List<SubCategory> fetSubCategoryForNav(String cTitle);

	List<SubCategory> fetchSubCategoriesForVendor(Integer id);
}
