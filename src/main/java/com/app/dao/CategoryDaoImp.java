package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Category;
import com.app.pojos.VendorCategory;

@Repository
public class CategoryDaoImp implements ICategoryDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public String createMainCategory(Category transientCategory) {
		mgr.persist(transientCategory);
		return "New Category Created with Id " + transientCategory.getId();
	}

	@Override
	public List<Category> fetchMainCategories() {
		String jpql = "select c from Category c";
		return mgr.createQuery(jpql, Category.class).getResultList();
	}

	@Override
	public Category fetchMainCategory(int id) {
		return mgr.find(Category.class, id);
	}

	@Override
	public String toggleCategory(String title, String status) {
		String jpql = "update Category c SET c.cStatus=:status where c.cTitle=:title";
		mgr.createQuery(jpql).setParameter("status", status).setParameter("title", title).executeUpdate();
		return "Category status Changed to " + status;
	}

	@Override
	public String deleteCategory(Category cid) {
		mgr.remove(cid);
		return "Category is Deleted for id=" + cid.getId();
	}
	@Override
	public int countOfCategory() {
		String jpql = "select a from Category a";
		int count=0;
		List<Category> a=mgr.createQuery(jpql, Category.class).getResultList();
		for (@SuppressWarnings("unused") Category cat : a) {
			count++;
		}
		return count;
	}

	@Override
	public Category fetchCategory(String cTitle) {
		String jpql="select c from Category c where c.cTitle=:cTitle";
		return mgr.createQuery(jpql, Category.class).setParameter("cTitle", cTitle).getSingleResult();
	}

	@Override
	public VendorCategory fetchVendorCategory(int id) {
		
		return mgr.find(VendorCategory.class, id);
	}

	

}
