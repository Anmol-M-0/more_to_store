package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdditionalDetailsRepository;
import com.app.dao.AddressRepository;
import com.app.dao.CardRepository;
import com.app.dao.CartItemRepository;
import com.app.dao.CartRepository;
import com.app.dao.CustomerRepository;
import com.app.dao.ICustomerDao;
import com.app.dao.NetBankingRepository;
import com.app.dao.OrderRepository;
import com.app.dao.ProductRepository;
import com.app.dao.ShippingAddressRepository;
import com.app.dao.UpiRepository;
import com.app.dao.WishlistRepository;
import com.app.dto.CustomerRegistrationFormDTO;
import com.app.pojos.AdditionalDetails;
import com.app.pojos.Address;
import com.app.pojos.Card;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.NetBanking;
import com.app.pojos.Order;
import com.app.pojos.OrderItem;
import com.app.pojos.PaymentMode;
import com.app.pojos.ShippingAddress;
import com.app.pojos.SupportedPaymentModesEnum;
import com.app.pojos.Upi;
import com.app.pojos.Wishlist;
import static com.app.utils.OrderUtil.*;
@Service
@Transactional
public class CustomerServiceImp implements ICustomerService {
	
	
	@Autowired
	private ICustomerDao customerDao;
	@Autowired
	private CustomerRepository customerRepository;

//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private CartItemRepository cartItemRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Autowired
	private AdditionalDetailsRepository additionalDetailsRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UpiRepository upiRepository;
	
	@Autowired
	private NetBankingRepository netRepository;
	
	@Autowired
	private IOrderService orderService;
	
	@Override
	public String registerCustomer(Customer customer) {//changes here
		
		Cart cart = new Cart();
		cart = cartRepository.save(cart);
		Wishlist wishlist = new Wishlist();
		wishlistRepository.save(wishlist);
		customer.setCart(cart);
		customer.setWishlist(wishlist);
		AdditionalDetails additionalDetails = new AdditionalDetails();
		additionalDetails.setCustomerAddress(new Address("-", "-", "-", "-", "-", "-", 0, "-"));
		additionalDetails = additionalDetailsRepository.save(additionalDetails);
		customer.setAdditionalDetails(additionalDetails);
		customerRepository.save(customer);
		
		return "customer registered successfully";
	}

	@Override
	public Customer validateCustomer(String email, String password) {

		return customerDao.validateCustomer(email, password);
	}

	@Override
	public String saveCustomerRegistration(CustomerRegistrationFormDTO customerRegDTO) {
		System.out.println("in save customer registration");
		Customer customer = customerRegDTO.getCustomer();
		Cart cart = new Cart();
		cart = cartRepository.save(cart);
		Wishlist wishlist = new Wishlist();
		wishlist = wishlistRepository.save(wishlist);
		customer.setCart(cart);
		customer.setWishlist(wishlist);
		customer.setAdditionalDetails(new AdditionalDetails());
		customer.setName(customerRegDTO.getFirstName() + " " + customerRegDTO.getMiddleName() + " "
				+ customerRegDTO.getLastName());
		System.out.println(customer.getAdditionalDetails());
		System.out.println(customerRegDTO.getCustomerAddress());
		customer.getAdditionalDetails().setCustomerAddress(customerRegDTO.getCustomerAddress());
		customerRepository.save(customer);
		return "Customer registered successfully ....";
	}

	@Override
	public String saveAddress(Address a, Customer c) {
		//c.getAdditionalDetails().setCustomerAddress(a);
		System.out.println(c);
		System.out.println(c.getAdditionalDetails());
		System.out.println(c.getAdditionalDetails().getCustomerAddress());
		System.out.println("*******   "+c.getAdditionalDetails().getCustomerAddress().getId());
	
		addressRepository.updateAddress(a.getAddressLine1(),a.getAddressLine2(),a.getCity(),a.getState(),a.getDistrict(),a.getPostOffice(),a.getPincode(),a.getCountry(),c.getAdditionalDetails().getCustomerAddress().getId());
		return "address saved successfully";
	}

	@Override
	public Customer getUpdatedCustomer(Customer c) {
		return 	customerRepository.findById(c.getId()).orElseThrow(()-> new RuntimeException("cust not found"));
	}
	@Override
	public String saveShippingAddress(Address ship, Customer customer) {
		Address a = addressRepository.save(ship);	
		ship.setId(a.getId());
		ShippingAddress s= new ShippingAddress();
		s.setAddress(a);
		s=shippingAddressRepository.save(s);
		System.out.println("in service----------"+fetchShippingAddresses(customer));
		customer.getAdditionalDetails().addShippingAddress(s);
		
		return "shipping address added";
	}

	@Override
	public String fetchShippingAddresses(Customer customer) {
		Set<ShippingAddress> set = customer.getAdditionalDetails().getShippingAddresses();
		customer.getAdditionalDetails().setShippingAddresses(set);
		return "success";
	}

	@Override
	public Card saveCard(String cardname, String cardnumber, String expmonth, String expyear, int cvv) {
		Card c= new Card(cardnumber, cardname, expyear, expmonth, cvv);
		Card save = cardRepository.save(c);
		return save;
	}

	@Override
	public Upi saveUpi(String upiMode, String id) {
		Upi u= new Upi(upiMode, id);
		Upi save = upiRepository.save(u);
		return save;
	}

	@Override
	public NetBanking saveNetBanking(String bankName, String userId) {
		NetBanking b= new NetBanking(bankName, userId);
		NetBanking save = netRepository.save(b);
		return save;
	}

	@Override
	public String addOrder(Customer customer, Address shippingAddress, PaymentMode paymentMode, Double total,
			LocalDateTime shippingDate, LocalDateTime orderDate, SupportedPaymentModesEnum mode) {
		orderService.saveOrder(customer, shippingAddress, paymentMode, total, shippingDate, orderDate, mode);//
		System.out.println("step 6 - end");
		return "order saved successfully";
	}

}
