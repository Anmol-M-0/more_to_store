package com.app.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.dao.ICategoryDao;
import com.app.dao.ISubCategoryDao;
import com.app.dao.VendorRepository;
import com.app.pojos.Category;
import com.app.pojos.SubCategory;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;


@Transactional
@Service
public class SubCategoryServiceImpl implements ISubCategoryService {
	@Autowired
	private ISubCategoryDao subCategoryDao;
	@Autowired
	private ICategoryDao categoryDao;
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public String createNewSubCategory(int cid, String subTitle) {
		Category parentCategory =categoryDao.fetchMainCategory(cid);
		return subCategoryDao.createSubCategory(parentCategory, subTitle, "Hide");
	}
	@Override
	public List<SubCategory> fetchSubCategories() {
		return subCategoryDao.fetchSubCategories();
	}
	@Override
	public String toggleSubCategory(int id) {
		SubCategory subCategory = subCategoryDao.fetchSubCategory(id);
		if (subCategory.getSubStatus().equals("Hide"))
			return subCategoryDao.toggleSubCategory(subCategory.getId(), "Show");
		else
			return subCategoryDao.toggleSubCategory(subCategory.getId(), "Hide");
	}
	@Override
	public String deleteCategory(int sid) {
		SubCategory sc=subCategoryDao.fetchSubCategory(sid);
		return subCategoryDao.deleteCategory(sc);
	}

	@Override
	public int countOfSubCategory() {
		// TODO Auto-generated method stub
		return subCategoryDao.countOfSubCategory();
	}
	@Override
	public List<VendorCategory> fetchVendorCategory(Vendor v) {
		
		return subCategoryDao.fetchVendorCategory(v);
	}
	@Override
	public SubCategory fetchSubCategory(int subCId) {
		
		return subCategoryDao.fetchSubCategory(subCId);
	}
	@Override
	public List<SubCategory> fetSubCategoryForNav(String cTitle) {
		Category mainCategory=categoryDao.fetchCategory(cTitle);
		return subCategoryDao.fetSubCategoryForNav(mainCategory);
	}
	@Override
	public List<SubCategory> fetchSubCategoriesForVendor(Integer id) {
		return subCategoryDao.fetchVendorSubCategories(id);
	}
	
	
}
