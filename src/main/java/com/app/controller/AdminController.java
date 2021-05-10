package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.VendorRegistrationFormDto;
import com.app.dto.VendorUpdationDTO;
import com.app.exceptions.AdminControllerException;
import com.app.exceptions.CatchAllException;
import com.app.pojos.Advertise;
import com.app.pojos.Banner;
import com.app.pojos.Category;
import com.app.pojos.SubCategory;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;
import com.app.service.IAdvertiseService;
import com.app.service.IBannerService;
import com.app.service.ICategoryService;
import com.app.service.ISubCategoryService;
import com.app.service.IVendorService;
import com.app.utils.VendorUtils;

@Controller
@RequestMapping("/admin")
public class AdminController {
	public static final Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ISubCategoryService subCategoryService;
	@Autowired
	private IBannerService bannerService;
	@Autowired
	private IAdvertiseService advertiseService;
	@Autowired
	private IVendorService vendorService;
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	public AdminController() {
//		System.out
		
		log.debug("in constructor of " + getClass().getName());
		//error, debug, info, trace, warn
	}

	@PostConstruct
	public void anyInit() {
		log.debug("in init of " + getClass().getName() + " " + categoryService);
	}

	/* Provide Admin Dashboard */

	@GetMapping("/admin_dashboard")
	public String showAdminHome(HttpSession hs) {
		try {
			log.debug("In show admin home");
			hs.setAttribute("countOfAdvertise", advertiseService.countOfAdvertise());
			hs.setAttribute("countOfBanner", bannerService.countOfBanner());
			hs.setAttribute("countOfCategory", categoryService.countOfCategory());
			hs.setAttribute("countOfSubCategory", subCategoryService.countOfSubCategory());
		} catch (Exception e) {
			throw new CatchAllException();
		}
		return "/admin/admin_dashboard";
	}

	/* Category Crud Operation */

	@GetMapping("/category")
	public String showCategory(Model modelMap, HttpSession hs) {
		
		log.debug("In show Category");
		try {
			List<Category> categoryList = new ArrayList<>();
			categoryList = categoryService.fetchMainCategories();
			hs.setAttribute("categoryList", categoryList);
			return "/admin/category";
		} catch (RuntimeException e) {
			log.debug("In show Category proble:" + e);
			return "/admin/category";
		}
	}

	@PostMapping("/category")
	public String saveMainCategory(@RequestParam String title, @RequestParam MultipartFile image,
			RedirectAttributes flashMap, Model modelMap, HttpSession hs) throws IOException {
		log.debug("in saveMainCategory");
		try {
			byte[] imageFile = image.getBytes();
			log.debug("image size : {} ", image.getSize());// restriction on size of the file?
			Category mainCategory = new Category(title, "hide", imageFile);
			flashMap.addFlashAttribute("message", categoryService.createMainCategory(mainCategory));
			return "redirect:/admin/category";
		} catch (RuntimeException e) {
			log.debug("in saveMainCategory " + e);
			modelMap.addAttribute("Message", "Some Problem Occured.. Please try again ");
			return "/admin/category";
		}
	}

	@GetMapping("/category_status")
	public String changeCategoryStatus(Model modelMap, Category c, @RequestParam int cid, HttpSession hs,
			HttpServletRequest request, HttpServletResponse resp) {
		log.debug("in change Category status : cid = {} ", cid);
		try {
			modelMap.addAttribute("message", categoryService.toggleCategory(cid));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/category");
			return "/admin/category";
		} catch (RuntimeException e) {
			log.debug("In show Category proble:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/category");
			return "/admin/category";
		}
	}

	@GetMapping("/category_delete")
	public String deleteCategory(Model modelMap, @RequestParam int cid, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		try {
			modelMap.addAttribute("message", categoryService.deleteCategory(cid));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/category");
			return "/admin/category";
		} catch (RuntimeException e) {
			log.debug("In show Category proble: ", e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/category");
			return "/admin/category";
		}
	}

	@GetMapping("/subcategory")
	public String showSubCategory(Model modelMap, HttpSession hs) {
		log.debug("In show Category");
		try {
			List<Category> categoryList = new ArrayList<>();
			categoryList = categoryService.fetchMainCategories();
			hs.setAttribute("categoryList", categoryList);

			List<SubCategory> subCategoryList = new ArrayList<>();
			subCategoryList = subCategoryService.fetchSubCategories();
			hs.setAttribute("subCategoryList", subCategoryList);
			return "/admin/subcategory";
		} catch (RuntimeException e) {
			log.debug("In show Category proble: {} ", e);
			return "/admin/subcategory";
		}
	}

	@PostMapping("/subcategory")
	public String saveSubCategory(@RequestParam int cid, @RequestParam(name = "subCTitle") String subTitle,
			RedirectAttributes flashMap, Model modelMap, HttpSession hs) throws IOException {
		log.debug("in saveSubCategory");
		try {
			if (subTitle.length() > 100)// validation on length of subTitle
				throw new RuntimeException("the title exceeds expected length");
			flashMap.addFlashAttribute("message", subCategoryService.createNewSubCategory(cid, subTitle));
			return "redirect:/admin/subcategory";
		} catch (RuntimeException e) {
			log.debug("in saveMainCategory {} ", e);
			modelMap.addAttribute("Message", "Some Problem Occours Please try again ");
			return "/admin/subcategory";
		}
	}

	@GetMapping("/subCategory_status")
	public String changeSubCategoryStatus(Model modelMap, SubCategory sc, @RequestParam int sid, HttpSession hs,
			HttpServletRequest request, HttpServletResponse resp) {
		log.debug("in change Sub Category status {} ", sid);
		try {
			modelMap.addAttribute("message", subCategoryService.toggleSubCategory(sid));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/subcategory");
			return "/admin/subcategory";
		} catch (RuntimeException e) {
			log.debug("In show Category proble: {} ", e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/subcategory");
			return "/admin/subcategory";
		}
	}

	@GetMapping("/subCategory_delete")
	public String deleteSubCategory(Model modelMap, @RequestParam int sid, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		try {
			modelMap.addAttribute("message", subCategoryService.deleteCategory(sid));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/subcategory");
			return "/admin/subcategory";
		} catch (RuntimeException e) {
			log.debug("In show Category proble:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/subcategory");
			return "/admin/subcategory";
		}
	}

	@GetMapping("/banner")
	public String showBanner(Model modelMap, HttpSession hs) {
		log.debug("In show Banner");
		try {
			List<Category> categoryList = new ArrayList<>();
			List<Banner> bannerList = new ArrayList<>();

			categoryList = categoryService.fetchMainCategories();
			hs.setAttribute("categoryList", categoryList);

			bannerList = bannerService.fetchAllBanner();
			hs.setAttribute("bannerList", bannerList);

			return "/admin/banner";
		} catch (RuntimeException e) {
			log.debug("In show banner problem:" + e);
			return "/admin/banner";
		}
	}

	@PostMapping("/banner")
	public String saveBanner(@RequestParam int cid, @RequestParam MultipartFile image, RedirectAttributes flashMap,
			Model modelMap, HttpSession hs) throws IOException {
		log.debug("in saveBanner ");
		try {
			log.debug("image size ", image.getSize());// constraints on size?

			byte[] imageFile = image.getBytes();
			Category cat = categoryService.fetchMainCategory(cid);
			Banner banner = new Banner(cat.getcTitle(), "hide", imageFile);
			flashMap.addFlashAttribute("message", bannerService.addBanner(banner));
			return "redirect:/admin/banner";
		} catch (RuntimeException e) {
			log.debug("in saveBanner " + e);
			modelMap.addAttribute("Message", "Some Problem Occured.. Please try again ");
			return "/admin/banner";
		}
	}

	@GetMapping("/banner_status")
	public String changeBannerStatus(Model modelMap, Banner b, @RequestParam int id, HttpSession hs,
			HttpServletRequest request, HttpServletResponse resp) {
		log.debug("in change Banner status" + id);
		try {
			modelMap.addAttribute("message", bannerService.toggleBanner(id));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/banner");
			return "/admin/banner";
		} catch (RuntimeException e) {
			log.debug("Error In Change status - Banner:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/banner");
			return "/admin/banner";
		}
	}

	@GetMapping("/banner_delete")
	public String deleteBanner(Model modelMap, @RequestParam int id, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		try {
			modelMap.addAttribute("message", bannerService.deleteBanner(id));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/banner");
			return "/admin/banner";
		} catch (RuntimeException e) {
			log.debug("Error In Delete Banner :" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/banner");
			return "/admin/banner";
		}
	}

	@GetMapping("/advertisement")
	public String showAdvertisement(Model modelMap, HttpSession hs) {
		log.debug("In Show Advertisement");
		List<Advertise> advertiseList = new ArrayList<>();
		advertiseList = advertiseService.fetchAdvertisements();
		hs.setAttribute("advertiseList", advertiseList);

		List<Category> categoryList = new ArrayList<>();
		categoryList = categoryService.fetchMainCategories();
		hs.setAttribute("categoryList", categoryList);

		return "/admin/advertisement";
	}

	@PostMapping("/advertisement")
	public String saveAdvertisement(@RequestParam String category, @RequestParam MultipartFile image,
			RedirectAttributes flashMap, Model modelMap, HttpSession hs, HttpServletResponse resp,
			HttpServletRequest request) throws IOException {
		log.debug("in saveAdvertisement");
		try {
			byte[] imageFile = image.getBytes();// should we validate file size?
			log.debug("image size ", image.getSize());
			Advertise add = new Advertise(category, "Hide", imageFile);
			flashMap.addFlashAttribute("message", advertiseService.publishAdvertise(add));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/advertisement");
			return "redirect:/admin/advertisement";
		} catch (RuntimeException e) {
			log.debug("in saveAdvertisement " + e);
			modelMap.addAttribute("Message", "Some Problem Occours Please try again ");
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/advertisement");
			return "/admin/advertisement";
		}
	}

	@GetMapping("/advertise_status")
	public String changeAdvertiseStatus(Model modelMap, Category c, @RequestParam int aid, HttpSession hs,
			HttpServletRequest request, HttpServletResponse resp) {
		log.debug("in change advertise status" + aid);
		try {
			modelMap.addAttribute("message", advertiseService.toggleAdvertise(aid));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/advertisement");
			return "/admin/advertisement";
		} catch (RuntimeException e) {
			log.debug("In show advertise proble:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/advertisement");
			return "/admin/advertisement";
		}
	}

	@GetMapping("/advertise_delete")
	public String deleteAdvertise(Model modelMap, @RequestParam int aid, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		try {
			modelMap.addAttribute("message", advertiseService.deleteAdvertise(aid));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/advertisement");
			return "/admin/advertisement";
		} catch (RuntimeException e) {
			log.debug("In show advertise proble:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/advertisement");
			return "/admin/advertisement";
		}
	}

	@GetMapping("/vendor_registration")
	public String showVendorRegistration(Model modelMap, HttpSession hs) {
		log.debug("In showVendorRegistration");
		try {
			List<SubCategory> subCategoryList = new ArrayList<>();
			subCategoryList = subCategoryService.fetchSubCategories();
			hs.setAttribute("subCategoryList", subCategoryList);
			modelMap.addAttribute("registration", new VendorRegistrationFormDto());
		} catch (Exception e) {
			throw new AdminControllerException();
		}
		return "/admin/vendor_registration";
	}

	@PostMapping("/vendor_registration")
	public String processVendorRegisteration(@ModelAttribute("registration") VendorRegistrationFormDto registration,
			BindingResult result, RedirectAttributes flashMap) {
		log.debug("in process vendor registration");
		try {
			if (result.hasErrors()) {
				log.debug("in has errors");
				flashMap.addFlashAttribute("message", "error in vendor registeration, vendor not registered");
				return "redirect:/admin/vendor_registration";

			}
			log.debug("in no errors");
			String str = vendorService.saveVendorRegisteration(registration);
			log.debug(str);
			flashMap.addFlashAttribute("message", str);
		} catch (Exception e) {
			throw new AdminControllerException();
		}
		return "redirect:/admin/admin_dashboard";

	}

	@GetMapping("/vendor_details")
	public String showVendorDetails(Model modelMap) {
		try {
			modelMap.addAttribute("vendorList", vendorService.fetchVendors());
		} catch (Exception e) {
			throw new AdminControllerException();
		}
		return "/admin/vendor_details";
	}

	@GetMapping("/vendor_status")
	public String changeVendorStatus(Model modelMap, Vendor v, @RequestParam int id, HttpSession hs,
			HttpServletRequest request, HttpServletResponse resp) {
		log.debug("in change Vendor status" + id);
		try {
			modelMap.addAttribute("message", vendorService.toggleVendor(id));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/vendor_details");
			return "/admin/vendor_details";
		} catch (RuntimeException e) {
			log.debug("In change vendor status proble:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/vendor_details");
			return "/admin/vendor_details";
		}
	}

	@GetMapping("/vendor_delete")
	public String deleteVendor(Model modelMap, @RequestParam int id, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		try {

			log.debug("in delete vendor");
			modelMap.addAttribute("message", vendorService.deleteVendor(id));
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/vendor_details");
			return "/admin/vendor_details";
		} catch (RuntimeException e) {
			log.debug("In vendor delete proble:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/admin/vendor_details");
			return "/admin/vendor_details";
		}
	}

	@GetMapping("/vendor_updation")
	public String showUpdateVendorDetails(@RequestParam("id") int id, Model modelMap, HttpSession session) {
		try {
			session.setAttribute("subCategories", subCategoryService.fetchSubCategories());
			Vendor vendor = vendorService.fetchVendorByID(id);// has old categories
			session.setAttribute("vendorInformation", vendor);

			modelMap.addAttribute("addressInformation", vendor.getVendorAddress());
			modelMap.addAttribute("vendor", new VendorUpdationDTO());
		} catch (Exception e) {
			throw new AdminControllerException();
		}
		return "/admin/vendor_updation";
	}

	@PostMapping("/vendor_updation")
	public String updateVendorDetails(@ModelAttribute("vendor") VendorUpdationDTO vendor,
			@SessionAttribute("subCategories") List<SubCategory> subCategories,
			@SessionAttribute("vendorInformation") Vendor vendorInformation, BindingResult result, Model modelMap,
			HttpSession session) {
		try {
			log.debug(subCategories.toString());
			log.debug("strs : " + vendor.getStrs());// selected cats
			List<Integer> ints = vendor.getStrs().stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList());// list
																														// of
																														// id's
			List<VendorCategory> collect = subCategories.stream().filter(i -> ints.contains(i.getId()))
					.map(i -> new VendorCategory(i.getSubCTitle())).collect(Collectors.toList());// selected categories
																									// set
			log.debug("collected cats : " + collect);
			vendor.setVendorCategories(collect);// to the dto
			log.debug(vendor.getVendorInfo().toString());
			log.debug(vendorInformation.toString());
			VendorUtils.fetchVendor(vendor, vendorInformation);// refactored
			String message = vendorService.updateVendor(vendor);
			logger.info("mesage : {}", message);
			modelMap.addAttribute("message", message);
		} catch (Exception e) {
			throw new AdminControllerException();
		}
		return "redirect:/admin/admin_dashboard";
	}

}
