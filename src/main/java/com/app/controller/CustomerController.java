package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.exceptions.CartException;
import com.app.exceptions.CustomerException;
import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.Fashion;
import com.app.pojos.Mobile;
import com.app.pojos.PaymentMode;
import com.app.pojos.SubCategory;
import com.app.pojos.SupportedPaymentModesEnum;
import com.app.pojos.Wishlist;
import com.app.service.IBannerService;
import com.app.service.ICartService;
import com.app.service.ICustomerService;
import com.app.service.IFashionService;
import com.app.service.IMobileService;
import com.app.service.IProductService;
import com.app.service.ISubCategoryService;
import com.app.service.IWishlistService;
import com.app.utils.CardUtils;
import static com.app.pojos.SupportedPaymentModesEnum.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private IProductService productService;
	@Autowired
	private ISubCategoryService subCategoryService;
	@Autowired
	private IBannerService bannerService;
	@Autowired
	private IMobileService mobileservice;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IFashionService fashionService;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IWishlistService wishlistService;

	@GetMapping("/show_Mobiles")
	public String showMobilePage(@RequestParam int subCId, HttpSession hs, Model modelMap) {
		log.info("sub CID : {} ", subCId);

		SubCategory subCat = subCategoryService.fetchSubCategory(subCId);
		log.info("in Show Mobile Page : {} ", subCat.getSubCTitle());
		List<Mobile> mobileList = productService.fetchMobiles(subCat.getSubCTitle());
		log.info("mobile list " + mobileList);
		if (mobileList != null) {
			hs.setAttribute("mobileList", mobileList);
			hs.setAttribute("bannerList", bannerService.fetchCustomerBanner());
			return "/customer/show_Mobiles";
		} else {
			modelMap.addAttribute("productNotAvailableMessage",
					"Sorry Currently " + subCat.getSubCTitle() + " are not Available");
			return "/customer/show_Mobiles";
		}
	}

	@GetMapping("/show_Fashion")
	public String showFashionPage(@RequestParam int subCId, HttpSession hs, Model modelMap) {
		log.info("sub CID : {} ", subCId);
		SubCategory subCat = subCategoryService.fetchSubCategory(subCId);
		log.info("in Show Mobile Page : {} ", subCat.getSubCTitle());
		List<Fashion> fashionList = productService.fetchFashions(subCat.getSubCTitle());
		log.info("fashion list : {}", fashionList);
		if (fashionList != null) {
			hs.setAttribute("fashionList", fashionList);
			hs.setAttribute("bannerList", bannerService.fetchCustomerBanner());
			return "/customer/show_Fashion";
		} else {
			hs.setAttribute("productNotAvailableMessage",
					"Sorry Currently " + subCat.getSubCTitle() + " are not Available");
			return "/customer/show_Fashion";
		}
	}

	@GetMapping("/mobile_details")
	public String showMobileDetails(@RequestParam Long pid, Model modelMap) {
		log.info("in show mobile details");
		try {
			Mobile mobileDetails = mobileservice.getMobile(pid);
			modelMap.addAttribute("mobile", mobileDetails);
			log.info("---> {} ", mobileDetails);
		} catch (Exception e) {
			throw new CustomerException();
		}
		return "/customer/mobile_details";
	}

	@GetMapping("/fashion_details")
	public String showFashionDetails(@RequestParam Long pid, Model modelMap) {
		System.out.println("in show fashion details");
		try {
			Fashion fashionDetails = fashionService.getFashion(pid);
			modelMap.addAttribute("fashion", fashionDetails);
			System.out.println("--->" + fashionDetails);
		} catch (Exception e) {
			throw new CustomerException();
		}
		return "/customer/fashion_details";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "/customer/login";
	}

	@GetMapping("/register")
	public String showRegister() {
		return "/customer/register";
	}

	@GetMapping("view_cart")
	public String viewCart(HttpSession hs, Model modelMap) {
		try {
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			int quantity = customer.getCart().getCartItems().parallelStream().map(ci -> ci.getQuantity())
					.reduce((i, j) -> i + j).orElse(0);
			double sumTotal = customer.getCart().getCartItems().parallelStream()
					.map(i -> i.getProduct().getPrice() * i.getQuantity()).reduce((i, j) -> i + j).orElse(0D);
			modelMap.addAttribute("quantity", quantity);
			hs.setAttribute("sumTotal", sumTotal);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Some Techinical Problem Try Again");
			return "redirect:/";
		}
		return "/customer/view_cart";
	}

	@GetMapping("/addtowish")
	public String processAddToWishlist(@RequestParam Long pid, RedirectAttributes flashMap, Model modelMap,

			HttpSession hs, HttpServletRequest req) {
		try {
			log.info("in process wish list");
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			if (customer == null) {
				modelMap.addAttribute("loginMsg", "Please Login To Use this Service");
				return "/customer/login";
			}
			wishlistService.addToWishList(pid, customer);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "Some Error occoured");
			return "redirect:/";
		}
		return "/customer/view_wishlist";
	}

	@GetMapping("/view_wishlist")
	public String showWishlistPage(Model modelMap, HttpSession hs) {
		log.info("in show wishlist");
		try {
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			Wishlist wishlist = customer.getWishlist();
			wishlist.getWishlistItems().forEach(System.out::println);
		} catch (RuntimeException e) {
			return "redirect:/";
		}
		return "/customer/view_wishlist";
	}

	@GetMapping("/removeFromWishlist")
	public String removeFromWishList(@RequestParam Long pid, HttpSession hs, Model modelMap) {
		log.info("in remove wishlist");
		try {
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			String msg = wishlistService.removeItemFromWishList(pid, customer);
			log.info(msg);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "/customer/view_wishlist";
	}

	@GetMapping("/movetocart")
	public String moveToCart(@RequestParam Long pid, HttpSession hs, Model modelMap) {
		log.info("in moveto cart ");
		try {
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			String msg = wishlistService.moveToCart(pid, customer);
			log.info(msg);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "redirect:/customer/view_cart";
	}

	@GetMapping("/removeFromCart")
	public String removeFromCart(@RequestParam Long pid, HttpSession hs, Model modelMap) {
		log.info("in remove from cart");
		try {
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			String msg = cartService.removeFromCart(pid, customer);
			log.info(msg);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "redirect:/customer/view_cart";
	}

	@GetMapping("/movetowishlist") // not working
	public String moveToWishlist(@RequestParam Long pid, HttpSession hs, Model modelMap) {
		log.info("in move to wishlist ");
		try {
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			String msg = cartService.saveForLater(pid, customer);
			log.info(msg);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "/customer/view_wishlist";
	}

	@GetMapping("/addtocart")
	public String processAddToCart(@RequestParam Long pid, RedirectAttributes flashMap, Model modelMap, HttpSession hs,
			HttpServletRequest req) {
		try {
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			if (customer == null) {
				modelMap.addAttribute("loginMsg", "Please Login To Use this Service");
				return "/customer/login";
			}
			cartService.addToCart(pid, customer);
			log.info(req.getRequestURL().toString());
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "redirect:/customer/view_cart";

	}

	@GetMapping("/about_us")
	public String showAboutUs() {
		return "/customer/about_us";
	}

	@GetMapping("/check")
	public String Check(HttpSession hs, Model modelMap) {
		log.info("in  check-------");
		Customer customer = (Customer) hs.getAttribute("customerDetails");
		try {
			if (customer.getCart().getCartItems().size() <= 0)
				throw new CartException("no item found in cart");
			Address a = customer.getAdditionalDetails().getCustomerAddress();
			if (a.getPincode() == 0) {
				log.info("address null");
				return "redirect:/customer/add_address";
			}
			log.info("address not null");
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "cannot checkout");
			return "redirect:/";
		}
		return "redirect:/customer/checkout";
	}

	@GetMapping("/add_address")
	public String showAddAddressForm(Model modelMap, HttpSession hs) {
		log.info("in show address from");
		try {
			modelMap.addAttribute("customerAddress", new Address());
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "/customer/add_address";
	}

	@PostMapping("/add_address") // form binding
	public String processAddressForm(@ModelAttribute(name = "customerAddress") @Valid Address address,
			BindingResult result, HttpSession hs, RedirectAttributes flashMap, Model modelMap) {
		log.info("in process address form");
		try {
			if (result.hasErrors()) {
				flashMap.addFlashAttribute("message", "falied to add address to the customer");
				return "/";
			}
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			String str = customerService.saveAddress(address, customer);
			customer = customerService.getUpdatedCustomer(customer);
			hs.setAttribute("customerDetails", customer);
			log.info(customer.getAdditionalDetails().getCustomerAddress().toString());
			log.info(str);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "redirect:/customer/checkout";
	}

	@GetMapping("/checkout")
	public String showCheckout(Model modelMap) {
		log.info("in show chkout -----");
		try {
			modelMap.addAttribute("shipAddress", new Address());
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "/customer/checkout";
	}

	@PostMapping("/checkout") // binding
	public String processCheckoutPage(@ModelAttribute("shipAddress") Address ship, BindingResult result,
			RedirectAttributes flashMap, HttpSession hs, Model modelMap) {
		log.info("in process check out");
		try {
			if (result.hasErrors()) {
				flashMap.addFlashAttribute("message", "err in saving shipping address");
				return "/";
			}
			Customer customer = (Customer) hs.getAttribute("customerDetails");
			customerService.saveShippingAddress(ship, customer);
			hs.setAttribute("shippingAddress", ship);
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "/customer/payment";
	}

	@PostMapping("/payment")
	public String showPayment(@RequestParam String page, HttpSession hs, Model modelMap) {// refactored
		log.info("in show payment...");
		try {
			if (page.equals("card")) {
				hs.setAttribute("paymentModeENUM", CARD);
				return "redirect:/customer/card";
			}
			if (page.equals("upi")) {
				hs.setAttribute("paymentModeENUM", UPI);
				return "redirect:/customer/upi";
			}
			if (page.equals("netbanking")) {
				hs.setAttribute("paymentModeENUM", NETBANKING);
				return "redirect:/customer/netbanking";
			}
			if (page.equals("cod")) {
				hs.setAttribute("paymentModeENUM", COD);
				return "redirect:/customer/bill";
			}
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "/";
	}

	@GetMapping("/card")
	public String showCardPage() {
		log.info("in show card page...");
		return "/customer/card";
	}

	@PostMapping("/card")
	public String acceptCardDetails(@RequestParam String cardname, @RequestParam String cardnumber,
			@RequestParam String expmonth, @RequestParam String expyear, @RequestParam int cvv, Model modelMap,
			HttpSession hs) {
		try {
			CardUtils.validateForm(cardname, cardnumber, expmonth, expyear);
			hs.setAttribute("paymentMode", customerService.saveCard(cardname, cardnumber, expmonth, expyear, cvv));
		} catch (RuntimeException e) {
			log.info("there was an error in processing the request" + e);
			modelMap.addAttribute("message", "there was an error in processing the request : " + e.getMessage());
			return "redirect:/";
		}
		return "/customer/bill";
	}

	@GetMapping("/upi")
	public String showUpiPage() {
		log.info("in show Upi page...");
		return "/customer/upi";
	}

	@PostMapping("/upi")
	public String acceptUpiDetails(@RequestParam("upi") String upiMode, @RequestParam String id, HttpSession hs) {
		hs.setAttribute("paymentMode", customerService.saveUpi(upiMode, id));
		return "/customer/bill";
	}

	@GetMapping("/netbanking")
	public String showNetbankingPage() {
		log.info("in show netbanking page...");
		return "/customer/netbanking";
	}

	@PostMapping("/netbanking")
	public String acceptNetbankingDetails(@RequestParam(name = "bank_name") String bankName,
			@RequestParam("user_id") String userId, HttpSession hs) {
		hs.setAttribute("paymentMode", customerService.saveNetBanking(bankName, userId));
		return "/customer/bill";
	}

	@GetMapping("/bill")
	public String showCodPage() {
		log.info("in show cod page...");
		return "/customer/bill";
	}

	@GetMapping("/thankyou")
	public String showDonePage(HttpServletResponse resp, HttpServletRequest req, HttpSession session,Model modelMap) {
		try {
			Customer customer = (Customer) session.getAttribute("customerDetails");
			LocalDateTime orderDate = LocalDateTime.now();
			LocalDateTime shippingDate = orderDate.plusDays(15);
			Address shippingAddress = (Address) session.getAttribute("shippingAddress");
			PaymentMode paymentMode = (PaymentMode) session.getAttribute("paymentMode");
			SupportedPaymentModesEnum mode = (SupportedPaymentModesEnum) session.getAttribute("paymentModeENUM");
			Double total = customer.getCart().getCartItems().stream().map(i -> i.getProduct().getPrice())
					.reduce((i, j) -> i + j).orElse(0D);
			customerService.addOrder(customer, shippingAddress, paymentMode, total, shippingDate, orderDate, mode);
			System.out.println("step 8 end");
		} catch (RuntimeException e) {
			modelMap.addAttribute("message", "some Error Occoured");
			return "redirect:/";
		}
		return "/customer/thankyou";
	}
}
