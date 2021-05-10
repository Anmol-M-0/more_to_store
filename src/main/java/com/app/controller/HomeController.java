package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Category;
import com.app.pojos.Customer;
import com.app.pojos.SubCategory;
import com.app.service.IBannerService;
import com.app.service.ICategoryService;
import com.app.service.ICustomerService;
import com.app.service.IProductService;
import com.app.service.ISubCategoryService;

@Controller
public class HomeController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ISubCategoryService subCategoryService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IBannerService bannerService;
	public HomeController() {
		System.out.println("In constructor of " + getClass().getName());
	}
	//protected static <I> int getI(I i) {return 1;}
	@GetMapping("/")
	public String providerHomePage(HttpSession hs) {
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
		
		return "/index";
	}
	
	@GetMapping("/sub_category")
	public String showSubCategory(@RequestParam String category,HttpSession hs) {
		System.out.println("In provider Home Page");
		List<Category> mainCategory=categoryService.fetchMainCategories();
		hs.setAttribute("mainCategory",mainCategory );
		List<SubCategory> subCat=subCategoryService.fetSubCategoryForNav(category);
		if(subCat!=null) {
			hs.setAttribute("subCategory", subCat);
			return "redirect:/";
		}
		else
			return "/index";
		
	}
	
	@PostMapping("/register")
	public String registerCustomer(@RequestParam String name,@RequestParam String email,
			@RequestParam String mobile,@RequestParam String password,@RequestParam String password_confirmation,
			Model modelMap,HttpSession hs,RedirectAttributes flashMap) {
		System.out.println("in register"+name+" "+email+" "+mobile+" "+password+" "+password_confirmation);
		if(password.equals(password_confirmation)) {
		Customer cust=new Customer(name, email, password_confirmation, mobile);
		flashMap.addFlashAttribute("successMsg",customerService.registerCustomer(cust));
		return "redirect:/";
		}else {
			modelMap.addAttribute("errorMsg", "password not Matched");
			return "redirect:/";
		}
		
	}
	@GetMapping(value = "/404")
	public String handleErrorPage() {
		return "/";
	}
	
	@GetMapping("/contactus")
	public String showContactUs() {
		return "/contactus";
	}
	@GetMapping("/faqs")
	public String showFaqs() {
		return "/faqs";
	}
	
}