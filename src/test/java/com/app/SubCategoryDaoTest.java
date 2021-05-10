package com.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.ISubCategoryDao;
import com.app.dao.SubCategoryDaoImp;

public class SubCategoryDaoTest {
private ISubCategoryDao subCategoryDao;
public SubCategoryDaoTest() {
	subCategoryDao = new SubCategoryDaoImp();
}
@Test
public void testSubCDao() {
	subCategoryDao.fetchVendorSubCategories(1).stream().forEach(System.out::println);
	assertTrue(true);
}
}
