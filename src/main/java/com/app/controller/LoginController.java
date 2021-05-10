package com.app.controller;

import static com.app.utils.LoginUtils.validateEmailAndPasswordLength;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.Category;
import com.app.pojos.Customer;
import com.app.pojos.SubCategory;
import com.app.pojos.Vendor;
import com.app.service.IBannerService;
import com.app.service.ICategoryService;
import com.app.service.ICustomerService;
import com.app.service.ILoginService;
import com.app.service.IProductService;
import com.app.service.ISubCategoryService;


@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ISubCategoryService subCategoryService;
	
	@Autowired
	private IBannerService bannerService;
	public LoginController() {
		System.out.println("In constructor of " + getClass().getName());
	}

	@PostConstruct
	public void anyInit() {
		System.out.println("in init of " + getClass().getName() + " " + loginService);
	}

	@PostMapping("/login")
	public String loginCustomer(@RequestParam String email, @RequestParam String password, RedirectAttributes flashMap,
			HttpSession hs, Model modelMap) {
		System.out.println("login details " + email + " " + password);
		try {
			validateEmailAndPasswordLength(email, password);
			Customer customer = customerService.validateCustomer(email, password);
			hs.setAttribute("customerDetails", customer);
			return "redirect:/";
		} catch (RuntimeException e) {
			modelMap.addAttribute("errorMsg", "Invalid Crendentials for login ");
			return "redirect:/";
		}

	}

	@GetMapping("/admin_login")
	public String showAdminLogin() {
		System.out.println("in show admin login get method");
		return "/admin_login";
	}

	@PostMapping("/admin_login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,
			HttpSession hs) {
		System.out.println("in process login " + email + " " + password);
		try {
			validateEmailAndPasswordLength(email, password);
			Admin adminDetails = loginService.validateAdmin(email, password);
			hs.setAttribute("userDetails", adminDetails);
			return "redirect:/admin/admin_dashboard";
		} catch (RuntimeException e) {
			System.out.println("error in process login controller " + e);
			modelMap.addAttribute("message", "Invalid Login, Please Try Again");
			return "/index";
		}
	}

	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model modelMap, HttpServletRequest request,
			HttpServletResponse resp,HttpSession hs) {
		System.out.println("in userLogout " + getClass().getName());
		System.out.println("in user logout ");
		modelMap.addAttribute("details", session.getAttribute("user_details"));
		session.invalidate();
		System.out.println("In provider Home Page");
		List<Category> mainCategory=categoryService.fetchMainAndSubCategories();
		hs.setAttribute("mainCategory",mainCategory );
		List<SubCategory> subcategoryList=subCategoryService.fetchSubCategories();
		hs.setAttribute("subCategory",subcategoryList);
		hs.setAttribute("bannerList", bannerService.fetchCustomerBanner());
		hs.setAttribute("advList", bannerService.fetchCustomerAdvertise());
		hs.setAttribute("mobileList", productService.fetchMobiles("Apple"));
		hs.setAttribute("omobileList", productService.fetchMobiles("OPPO"));
		hs.setAttribute("fashionList", productService.fetchFashions("Men T-shirts"));
		resp.setHeader("refresh", "1;url=" + request.getContextPath());
		return "/index";

	}

	@GetMapping("/vendor_login")
	public String showVendorLogin() {
		System.out.println("in show vendor login get method");
		return "/vendor_login";
	}

	@PostMapping("/vendor_login")
	public String processVendorLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,
			HttpSession hs) {
		System.out.println("in processVendorLoginForm  " + email + " " + password);
		try {
			validateEmailAndPasswordLength(email, password);
			Vendor vendorDetails = loginService.validateVendor(email, password);
			String status = "NEW";
			hs.setAttribute("vendorDetails", vendorDetails);
			if (vendorDetails.getStatus().equals(status)) {
				return "redirect:/vendor/change_password";
			} else {
				hs.setAttribute("vendorDetails", vendorDetails);
				return "redirect:/vendor/vendor_dashboard";
			}
		} catch (RuntimeException e) {
			System.out.println("error in processVendorLoginForm  controller " + e);
			modelMap.addAttribute("message", "Invalid Login, Please Try Again");
			return "/vendor_login";
		}
	}

}
