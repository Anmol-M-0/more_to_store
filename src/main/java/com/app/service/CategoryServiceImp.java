package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.dao.ICategoryDao;
import com.app.dao.ISubCategoryDao;
import com.app.pojos.Category;
import com.app.pojos.SubCategory;

@Service
@Transactional
public class CategoryServiceImp implements ICategoryService {
	@Autowired
	private ICategoryDao categoryDao;
	@Autowired
	private ISubCategoryDao subCategoryDao;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public String createMainCategory(Category transientCategory) {
		return categoryDao.createMainCategory(transientCategory);
	}

	@Override
	public List<Category> fetchMainCategories() {
		return categoryDao.fetchMainCategories();
	}

	@Override
	public String toggleCategory(int id) {
		Category category = categoryDao.fetchMainCategory(id);
		if (category.getcStatus().equals("hide"))
			return categoryDao.toggleCategory(category.getcTitle(), "show");
		else
			return categoryDao.toggleCategory(category.getcTitle(), "hide");
	}

	@Override
	public String deleteCategory(int cid) {
		Category c = categoryDao.fetchMainCategory(cid);
		return categoryDao.deleteCategory(c);
	}

	@Override
	public Category fetchMainCategory(int id) {
		Category c = categoryDao.fetchMainCategory(id);
		return c;
	}
	@Override
	public int countOfCategory() {
		// TODO Auto-generated method stub
		return categoryDao.countOfCategory();
	}

	@Override
	public Category fetchCategory(String sc) {
		SubCategory subCat=subCategoryDao.fetchSubCategory(sc);
		System.out.println("sub category details "+subCat);
		return categoryDao.fetchMainCategory(subCat.getParentCategory().getId());
	}

	@Override
	public List<Category> fetchMainAndSubCategories() {
		List<Category> categories = categoryRepository.findAll();
		categories.forEach(c->{
			c.setSubCategories(c.getSubCategories());
			System.out.println(c.getSubCategories());
		});
		return categories;
	}

	
}
