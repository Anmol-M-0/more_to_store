package com.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.app.dto.FashionRegistrationFormDto;
import com.app.dto.MobileRegisterationFormDTO;
import com.app.pojos.Category;
import com.app.pojos.Fashion;
import com.app.pojos.ManufactureInformation;
import com.app.pojos.Mobile;
import com.app.pojos.Product;
import com.app.pojos.ProductImage;
import com.app.pojos.SubCategory;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;
import com.app.service.ICategoryService;
import com.app.service.IFashionService;
import com.app.service.ILoginService;
import com.app.service.IMobileService;
import com.app.service.IProductService;
import com.app.service.ISubCategoryService;
import com.app.utils.MobileUtil;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private ILoginService loginService;
	@Autowired
	private ISubCategoryService subCategoryService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IFashionService fashioService;

	@Autowired
	private IMobileService mobileService;

	public VendorController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/change_password")
	public String changVendorPassword() {
		System.out.println("in change vendor password");
		return "/vendor/change_password";
	}

	@PostMapping("/change_password")
	public String processchangePassword(@RequestParam String npassword, @RequestParam String cpassword, Model modelMap,
			HttpSession hs, RedirectAttributes flashMap) {
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		if (vendorDetails == null) {
			return "/vendor/change_password";
		} else {
			if (npassword.equals(cpassword)) {
				flashMap.addAttribute("message", loginService.changeVendorPassword(vendorDetails.getId(), cpassword));
				return "redirect:/vendor/vendor_dashboard";
			}
			modelMap.addAttribute("message", "Password Is Not Matched");
			return "/vendor/change_password";
		}
	}

	@GetMapping("/vendor_dashboard")
	public String showVendorDashboard(HttpSession hs) {
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		return "/vendor/vendor_dashboard";
	}

	@GetMapping("/product_add")
	public String showProductAdd(HttpSession hs, Model modelMap) {
		Vendor v = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", v);

		List<VendorCategory> vc = subCategoryService.fetchVendorCategory(v);

		hs.setAttribute("vendorCategory", vc);
		return "/vendor/product_add";
	}

	@PostMapping("/product_add")
	public String provideProductAddForm(@RequestParam String category, HttpSession hs, RedirectAttributes flashMap,
			Model modelMap) {

		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		Category mainCategory = categoryService.fetchCategory(category);

		if (mainCategory.getcTitle().equals("Mobiles")) {

			hs.setAttribute("subCategory", category);
			return "redirect:/vendor/add_mobiles";
		} else if (mainCategory.getcTitle().equals("Fashion")) {
			hs.setAttribute("subCategory", category);
			return "redirect:/vendor/add_fashion";
		} else {

			return "/vendor/vendor_dashboard";
		}
	}

	@GetMapping("/add_mobiles")
	public String showAddMobile(Model modelMap, HttpSession hs) {
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		return "/vendor/add_mobiles";
	}

	@PostMapping("/add_mobiles")
	public String saveMobile(@RequestParam MultipartFile image, @ModelAttribute MobileRegisterationFormDTO dto,
			Model modelMap, @SessionAttribute List<VendorCategory> vendorCategory, @SessionAttribute String subCategory,
			HttpSession hs, RedirectAttributes flashMap, HttpServletResponse resp, HttpServletRequest request)
			throws IOException {
		System.out.println("form info :" + dto);
		Mobile mobile = MobileUtil.getMobile(dto, vendorCategory, subCategory);
		System.out.println("mobile pojo : " + mobile);
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);

		mobile = mobileService.saveMobile(mobile, vendorDetails);
		System.out.println("saved mobile " + mobile);
		byte[] imageFile = image.getBytes();
		productService.uploadMainImage(mobile.getId(), imageFile);
		flashMap.addFlashAttribute("mobile saved with id " + mobile.getId());
		resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/vendor/show_category");
		return "/vendor/show_category";
	}

	// select * from sub_categories where sub_category_title in (select
	// category_title from vendor_category_tbl where vendor_id = 1);
	@GetMapping("/show_category")
	public String showCategoryList(Model modelMap, HttpSession hs) {
		System.out.println("in vendor show category ");
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		Set<VendorCategory> categoryList = vendorDetails.getVendorCategory();// <----
		// vendorcatid, subcatid, subcattitle,
//		List<SubCategory> subcats =  subCategoryService.fetchSubCategoriesForVendor(vendorDetails.getId());
		modelMap.addAttribute("categoryList", categoryList);
		return "/vendor/show_category";
	}

	@GetMapping("/product_list")
	public String showProductList(@RequestParam int id, Model modelMap, HttpSession hs) {
		System.out.println("in vendor show product list ");
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		hs.setAttribute("cat_id", id);// vendor category
		List<Mobile> allMobiles = mobileService.fetchAllMobiles(id, vendorDetails.getId());
		List<Fashion> allFashion = fashioService.fetchAllFashionProducts(id, vendorDetails.getId());
		if (allMobiles != null) {
			modelMap.addAttribute("allMobiles", allMobiles);
		}
		if (allFashion != null) {
			modelMap.addAttribute("allFashion", allFashion);
		}

		return "/vendor/product_list";
	}

	@GetMapping("/product_status")
	public String changeProductStatus(@RequestParam Long id, Model modelMap, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		System.out.println("in vendor change product status" + id);
		Integer cid = (Integer) hs.getAttribute("cat_id");// vendor_category_id
		String mainCat = productService.fetchCategoryTitle(cid);
		try {
			if (mainCat.equals("Mobiles")) {
				modelMap.addAttribute("message", mobileService.toggleMobile(id));
			}
			if (mainCat.equals("Fashion")) {
				modelMap.addAttribute("message", fashioService.toogleFashion(id));
			}

			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/vendor/product_list?id=" + cid);
			return "/vendor/product_list";
		} catch (RuntimeException e) {
			System.out.println("In show product problem:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/vendor/product_list?id=" + cid);
			return "/vendor/product_list";
		}
	}

	@GetMapping("/product_delete")
	public String deleteProduct(@RequestParam Long id, Model modelMap, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		Integer cid = (Integer) hs.getAttribute("cat_id");
		System.out.println("sub cat_id " + cid);
		String mainCat = productService.fetchCategoryTitle(cid);
		System.out.println("main cat_title " + mainCat);
		try {
			System.out.println("in product delete");
			if (mainCat.equals("Mobiles")) {
				mobileService.deleteMobile(id);
				System.out.println("mobile id " + id);
			}
			if (mainCat.equals("Fashion")) {
				fashioService.deleteFashion(id);
				System.out.println("fashion id " + id);
			}
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/vendor/product_list?id=" + cid);
			return "/vendor/product_list";
		} catch (RuntimeException e) {
			System.out.println("In show product problem:" + e);
			resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/vendor/product_list?id=" + cid);
			return "/vendor/product_list";
		}
	}

	@GetMapping("/product_update")
	public String showUpdateProduct(@RequestParam String id, Model modelMap, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		System.out.println("in product update");
		Product product = (Mobile) productService.fetchMobile(id);
		hs.setAttribute("mobileDetails", product);
		hs.setAttribute("descriptionDetails", productService.fetchDescription(product.getDescription().getId()));
		hs.setAttribute("technicalDetails",
				productService.fetchTechnicalDetails(productService.fetchMobile(id).getTechnicalDetails().getId()));
		ManufactureInformation mfgInfo = productService
				.fetchManufactureInformation(product.getManufactureInformation().getId());
		hs.setAttribute("manufactureInformation", mfgInfo);
		hs.setAttribute("mfgAddress", productService.fetchMfgAddress(mfgInfo.getManufactureLocation().getId()));
		return "/vendor/update_mobiles";
	}

	@PostMapping("/product_update")
	public String processUpdateProduct(Model modelMap, HttpServletRequest request, HttpServletResponse resp,
			@RequestParam String pid, @RequestParam int did, @RequestParam int tid, @RequestParam int mid,
			@RequestParam int aid, @RequestParam String status, @RequestParam String stock, @RequestParam String brand,
			@RequestParam String name, @RequestParam String title, @RequestParam String price,
			@RequestParam String offer, @RequestParam String dateAdded, @RequestParam String brief,
			@RequestParam String city, @RequestParam String state, @RequestParam String district,
			@RequestParam String country, @RequestParam String addressLine1, @RequestParam String addressLine2,
			@RequestParam String postOffice, @RequestParam String pincode, @RequestParam String manufactureDate,
			@RequestParam String manufactureInfo, @RequestParam String warrenty, @RequestParam String modelNo,
			@RequestParam String os, @RequestParam String ram, @RequestParam String dimensions,
			@RequestParam String batteryCapacity, @RequestParam String color, @RequestParam String connectivity,
			@RequestParam String display, @RequestParam String camera, @RequestParam String weight,
			@RequestParam String multimedia, @RequestParam String operatingFrequency, @RequestParam String resolution) {
		productService.updateProductTable(pid, stock, price, offer);
		productService.updateManufactureInfo(mid, warrenty, manufactureInfo);
		productService.updateAddress(aid, city, state, district, pincode, country, addressLine1, addressLine2,
				postOffice);
		productService.updateDescription(did, brief);
		productService.UpdateTechnicalDetails(tid, modelNo, os, ram, dimensions, batteryCapacity, color, connectivity,
				display, camera, weight, multimedia, operatingFrequency, resolution);
		modelMap.addAttribute("message", "supdate success");
		resp.setHeader("refresh", "1;url=" + request.getContextPath() + "/vendor/vendor_dashboard");
		return "/vendor/vendor_dashboard";
	}

	@GetMapping("/show_i_category")
	public String showICategoryList(Model modelMap, HttpSession hs) {
		System.out.println("in Image show category ");
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		Set<VendorCategory> categoryList = vendorDetails.getVendorCategory();
		modelMap.addAttribute("categoryList", categoryList);
		return "/vendor/show_i_category";
	}

	@GetMapping("/product_i_list")
	public String showIProductList(@RequestParam int id, Model modelMap, HttpSession hs) {
		System.out.println("in Image show product list ");
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		hs.setAttribute("cat_i_id", id);
		List<Mobile> allProducts = mobileService.fetchAllMobiles(id, vendorDetails.getId());
		modelMap.addAttribute("allProduct", allProducts);
		return "/vendor/product_i_list";
	}

	@GetMapping("/product_images")
	public String showImages(@RequestParam String proId, Model modelMap, HttpSession hs) {
		System.out.println("in list Image list ");

		int vendorId = (int) hs.getAttribute("cat_i_id");
		hs.setAttribute("vendorCategoriesId", vendorId);

		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);

		System.out.println("sesion category is " + hs.getAttribute("cat_i_id"));

		Mobile product = productService.fetchMobile(proId);
		hs.setAttribute("product", product);
		System.out.println("mobile details are " + product);
		modelMap.addAttribute("product", product);

		hs.setAttribute("productImages", productService.fetchProductImage(product));
		return "/vendor/product_images";
	}

	@PostMapping("/product_images")
	public String uploadImage(@RequestParam MultipartFile image, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp, RedirectAttributes flashMap, Model modelMap) throws IOException {
		System.out.println("in upload Image");
		try {
			byte[] imageFile = image.getBytes();
			Product p = (Mobile) hs.getAttribute("product");
			ProductImage pImage = new ProductImage(imageFile, p);
			hs.setAttribute("Message", productService.addImage(pImage));

			int vendorId = (int) hs.getAttribute("cat_i_id");
			hs.setAttribute("vendorCategoriesId", vendorId);

			resp.setHeader("refresh",
					"1;url=" + request.getContextPath() + "/vendor/product_images?proId=" + p.getId());
			return "redirect:/vendor/product_images?proId=" + p.getId();
		} catch (RuntimeException e) {
			Product p = (Mobile) hs.getAttribute("product");

			System.out.println("in save image " + e);
			modelMap.addAttribute("Message", "Some Problem Occured.. Please try again ");
			resp.setHeader("refresh",
					"1;url=" + request.getContextPath() + "/vendor/product_images?proId=" + p.getId());
			return "/vendor/product_images?proId=" + p.getId();
		}
	}

	@GetMapping("/image_delete")
	public String deleteImage(@RequestParam int proId, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp, RedirectAttributes flashMap) {
		System.out.println("in delete image ");
		Product p = (Mobile) hs.getAttribute("product");
		// flashMap.addFlashAttribute("Message", productService.deleteImage(proId));
		flashMap.addFlashAttribute("Message", productService.deleteImage(proId));
		return "redirect:/vendor/product_images?proId=" + p.getId();

	}

	@GetMapping("/add_fashion")
	public String showFashionpage(Model modelMap, HttpSession hs) {
		System.out.println("in show fashion page");
		Vendor vendorDetails = (Vendor) hs.getAttribute("vendorDetails");
		hs.setAttribute("vendorDetails", vendorDetails);
		modelMap.addAttribute("fashionItem", new FashionRegistrationFormDto());
		return "/vendor/add_fashion";
	}

	@PostMapping("/add_fashion")
	public String processFashionPage(@RequestParam MultipartFile image,
			@ModelAttribute(name = "fashionItem") FashionRegistrationFormDto fashionDto, BindingResult result,
			RedirectAttributes flashMap, @SessionAttribute List<VendorCategory> vendorCategory,
			@SessionAttribute String subCategory, HttpSession hs) throws IOException {
		System.out.println("in process fashion page");
		if (result.hasErrors()) {
			System.out.println("in has error of :" + getClass().getName());
			flashMap.addFlashAttribute("message", "falied to save fashion product");
		}
		Vendor vendor = (Vendor) hs.getAttribute("vendorDetails");
		byte[] imageFile = image.getBytes();
		String str = fashioService.saveFashionItem(fashionDto, vendorCategory, subCategory, vendor, imageFile);

		System.out.println("date-->" + fashionDto.getManufactureInformation().getManufactureDate());
		System.out.println("material-->" + fashionDto.getFashionInfo().getFashionDetails().getMaterial());
		System.out.println(str);
		return "/vendor/vendor_dashboard";
	}
}
