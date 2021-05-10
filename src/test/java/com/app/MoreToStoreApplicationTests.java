package com.app;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.ResultMatcher.matchAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.controller.AdminController;
import com.app.controller.CustomerController;
import com.app.controller.HomeController;
import com.app.controller.LoginController;
import com.app.controller.VendorController;
import com.app.dao.ISubCategoryDao;
import com.app.service.ILoginService;
@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebAppConfiguration
class MoreToStoreApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(MoreToStoreApplicationTests.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private ISubCategoryDao subCategoryDao;
	private MockMvc mockMvc;
	@MockBean
	private ILoginService loginService;

	@BeforeEach
	void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	void givenWac_whenServletContext_thenItProvidesHomeControllers() {
		log.info("in givenWac_whenServletContext_thenItProvidesHomeControllers");
		ServletContext servletContext = webApplicationContext.getServletContext();
		assertNotNull(servletContext);
		assertTrue(servletContext instanceof MockServletContext);
		assertNotNull(webApplicationContext.getBean(HomeController.class));
		assertNotNull(webApplicationContext.getBean(CustomerController.class));
		assertNotNull(webApplicationContext.getBean(LoginController.class));
		assertNotNull(webApplicationContext.getBean(AdminController.class));
		assertNotNull(webApplicationContext.getBean(VendorController.class));
	}

	@Test
	public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
		log.info("in givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName");
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(view().name("/index"));
	}

	@Test
	public void givenHomePageURI_whenMockMVC_thenVerifyResponse() throws Exception {
		log.info("in givenHomePageURI_whenMockMVC_thenVerifyResponse");
		MvcResult mvcResult = this.mockMvc.perform(get("/")).andDo(print())
				.andExpect(
						matchAll(status().isOk(), forwardedUrl("/WEB-INF/views/index.jsp"), flash().attributeCount(0)))
				.andReturn();
		System.out.println(mvcResult);
	}

	@Test
	public void givenSubCategoryURI_whenMockMVC_thenVerifyResponse() throws Exception {
		log.info("in givenSubCategoryURI_whenMockMVC_thenVerifyResponse");
		this.mockMvc.perform(get("/sub_category").param("category", "Mobiles")).andDo(print())
				.andExpect(matchAll(status().isFound(), redirectedUrl("/"), flash().attributeCount(0))).andReturn();

	}

	@Test
	public void testSubCDao() {
		System.out.println("testing vendor subcategories");
		subCategoryDao.fetchVendorSubCategories(1).stream().forEach(i -> {
			System.out.println("in test:");
			System.out.println(i.getId() + " " + i.getSubCTitle());

		});
		assertTrue(true);
	}

	@Test
	public void givenAdminLoginURI_whenMockMVC_thenVerifyResponse() throws Exception {
		log.info("in givenAdminLoginURI_whenMockMVC_thenVerifyResponse");
		MvcResult mvcResult = this.mockMvc.perform(get("/admin_login")).andDo(print()).andExpect(
				matchAll(status().isOk(), forwardedUrl("/WEB-INF/views/admin_login.jsp"), flash().attributeCount(0)))
				.andReturn();
		System.out.println(mvcResult);
	}

	@Test
	public void givenAdminLoginURI_whenMockMVC_thenVerifyPostResponse() throws Exception {
		log.info("in givenAdminLoginURI_whenMockMVC_thenVerifyPostResponse");
		MvcResult mvcResult = this.mockMvc
				.perform(post("/admin_login").param("email", "admin@gmail.com").param("password", "admin"))
				.andDo(print()).andExpect(matchAll(status().isFound(), flash().attributeCount(0))).andDo(print())
				.andReturn();
		
		System.out.println(mvcResult);
	}

	@Test
	public void givenCategoryURI_whenMockMVC_thenVerifyPostResponse() throws Exception {
		log.info("in givenCategoryURI_whenMockMVC_thenVerifyPostResponse");
		MvcResult mvcResult = this.mockMvc.perform(post("/category")).andDo(print()).andExpect(
				matchAll(status().isNotFound(), flash().attributeCount(0)))
				.andReturn();
		System.out.println(mvcResult);
	}
	@Test
	public void givenLogoutURI_whenMockMVC_thenVerifyResponse() throws Exception {
		log.info("in givenLogoutURI_whenMockMVC_thenVerifyPostResponse");
		MvcResult mvcResult = this.mockMvc.perform(get("/logout")).andDo(print()).andExpect(
				matchAll(status().isFound(),flash().attributeCount(0),redirectedUrl("/")))
				.andReturn();
		System.out.println(mvcResult);
	}
	@Test
	public void givenContactusURI_whenMockMVC_thenVerifyResponse() throws Exception {
		log.info("in givenContactusURI_whenMockMVC_thenVerifyPostResponse");
		MvcResult mvcResult = this.mockMvc.perform(get("/contactus")).andDo(print()).andExpect(
				matchAll(forwardedUrl("/WEB-INF/views/contactus.jsp"),status().isOk()))
				.andReturn();
		System.out.println(mvcResult);
	}
	@Test
	public void givenFaqsURI_whenMockMVC_thenVerifyResponse() throws Exception {
		log.info("in givenFaqsURI_whenMockMVC_thenVerifyPostResponse");
		MvcResult mvcResult = this.mockMvc.perform(get("/faqs")).andDo(print()).andExpect(
				matchAll(forwardedUrl("/WEB-INF/views/faqs.jsp"),status().isOk()))
				.andReturn();
		System.out.println(mvcResult);
	}
//	@Test//random num generator is predictable
//	public void givenRegisterURI_whenMockMVC_thenVerifyResponse() throws Exception {
//		log.info("in givenRegisterURI_whenMockMVC_thenVerifyPostResponse");
//		//name+" "+email+" "+mobile+" "+password+" "+password_confirmation
//		String pass = generateRandomString();
//		MvcResult mvcResult = this.mockMvc.perform(post("/register").param("name", generateRandomString())
//					.param("email", generateRandomString()).param("mobile",generateRandomMobileNumber())
//					.param("password", pass ).param("password_confirmation", pass))
//				.andDo(print()).andExpect(
//				matchAll(
//						status().isFound()))
//				.andReturn();
//		System.out.println(mvcResult);
//	}
//	static String generateRandomString() {
//		StringBuilder str = new StringBuilder();
//		for(int i=0; i<7; i++)
//			str.append((char) ((int)(Math.random()*27)+97));
//	
//		return str.toString();
//	}
//	static String generateRandomMobileNumber() {
//		StringBuilder str = new StringBuilder();
//		str.append(9);
//		for(int i=0; i<9;i++)
//			str.append((int)Math.random()*10);
//		return str.toString();
//	}
	@Test
	public void givenVendorLoginURI_whenMockMVC_thenVerifyPostResponse() throws Exception {
		log.info("in givenVendorLoginURI_whenMockMVC_thenVerifyPostResponse");
		MvcResult mvcResult = this.mockMvc
				.perform(get("/vendor_login"))
				.andDo(print()).andExpect(matchAll(status().isOk(), flash().attributeCount(0),
						forwardedUrl("/WEB-INF/views/vendor_login.jsp"))).andDo(print())
				.andReturn();
		
		System.out.println(mvcResult);
	}
}
