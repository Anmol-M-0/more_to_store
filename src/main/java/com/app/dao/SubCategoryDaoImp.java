package com.app.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Category;
import com.app.pojos.SubCategory;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

@Repository
public class SubCategoryDaoImp implements ISubCategoryDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public String createSubCategory(Category c, String sCTitle, String status) {
		SubCategory subCategory = new SubCategory(sCTitle, status);
		subCategory.setParentCategory(c);
		mgr.persist(subCategory);
		return "new Sub Category Created with Id " + subCategory.getId();
	}

	@Override
	public List<SubCategory> fetchSubCategories() {
		String jpql = "select sc from SubCategory sc";
		return mgr.createQuery(jpql, SubCategory.class).getResultList();
	}

	@Override
	public String toggleSubCategory(int id, String status) {
		String jpql = "update SubCategory sc SET sc.subStatus=:status where sc.id=:id";
		mgr.createQuery(jpql).setParameter("status", status).setParameter("id", id).executeUpdate();
		return "Sub Category status Changed to " + status;
	}

	@Override
	public SubCategory fetchSubCategory(int id) {

		return mgr.find(SubCategory.class, id);
	}

	@Override
	public String deleteCategory(SubCategory sid) {
		mgr.remove(sid);
		return "Sub Category is deleted with id " + sid.getId();
	}

	@Override
	public int countOfSubCategory() {
		String jpql = "select a from SubCategory a";
		int count = 0;
		List<SubCategory> a = mgr.createQuery(jpql, SubCategory.class).getResultList();
		for (@SuppressWarnings("unused")
		SubCategory sub : a) {
			count++;
		}
		return count;
	}

	@Override
	public List<VendorCategory> fetchVendorCategory(Vendor v) {
		String jpql = "select vc from VendorCategory vc where vc.vendorDetails=:id";
		return mgr.createQuery(jpql, VendorCategory.class).setParameter("id", v).getResultList();
	}

	@Override
	public SubCategory fetchSubCategory(String subCategory) {
		String jpql = "select subC from SubCategory subC where subC.subCTitle=:subCategory";
		return mgr.createQuery(jpql, SubCategory.class).setParameter("subCategory", subCategory).getSingleResult();
	}

	@Override
	public List<SubCategory> fetSubCategoryForNav(Category catId) {
		String jpql = "select subC from SubCategory subC where subC.parentCategory=:catId";
		return mgr.createQuery(jpql, SubCategory.class).setParameter("catId", catId).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategory> fetchVendorSubCategories(int id) {
		String sql = "select id, sub_category_title, sub_category_status from sub_categories where sub_category_title in (select category_title from vendor_category_tbl where vendor_id = ?)";
		List<Object[]> resultList = mgr.createNativeQuery(sql).setParameter(1, id).getResultList();
		return SubCategoryDaoImp.mapper(resultList);
	}

	private static List<SubCategory> mapper(List<Object[]> list) {
		List<SubCategory> collect = list.stream().map(oarr -> {
			SubCategory subCategory = new SubCategory();
			subCategory.setId((Integer) oarr[0]);
			subCategory.setSubCTitle((String) oarr[1]);
			subCategory.setSubStatus((String) oarr[2]);
			return subCategory;
		}).collect(Collectors.toList());
		return collect;
	}
}
