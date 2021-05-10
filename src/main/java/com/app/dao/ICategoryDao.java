package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface ICategoryDao {

	String createMainCategory(Category transientCategory);

	List<Category> fetchMainCategories();

	Category fetchMainCategory(int id);

	String toggleCategory(String title, String status);

	String deleteCategory(Category cid);
	
	int countOfCategory();
	
	Category fetchCategory(String cTitle);

	VendorCategory fetchVendorCategory(int id);
	
}
