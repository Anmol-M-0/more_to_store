package com.app.service;

import java.util.List;

import com.app.pojos.*;

public interface ICategoryService {

	String createMainCategory(Category transientCategory);

	List<Category> fetchMainCategories();

	Category fetchMainCategory(int id);

	String toggleCategory(int id);

	String deleteCategory(int cid);

	int countOfCategory();

	Category fetchCategory(String sc);
	
	List<Category> fetchMainAndSubCategories();
}
