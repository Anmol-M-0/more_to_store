package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.app.dto.CustomerRegistrationFormDTO;
import com.app.pojos.Address;
import com.app.pojos.Card;
import com.app.pojos.Customer;
import com.app.pojos.NetBanking;
import com.app.pojos.PaymentMode;
import com.app.pojos.SupportedPaymentModesEnum;
import com.app.pojos.Upi;

public interface ICustomerService {
	String registerCustomer(Customer cust);

	Customer validateCustomer(String email, String password);

	String saveCustomerRegistration(CustomerRegistrationFormDTO customerRegDTO);
	
	String saveAddress(Address a,Customer c);

	String saveShippingAddress(Address ship, Customer customer);

	String fetchShippingAddresses(Customer customer);

	Customer getUpdatedCustomer(Customer c);

	Card saveCard(String cardname, String cardnumber, String expmonth, String expyear, int cvv);

	Upi saveUpi(String upiMode, String id);

	NetBanking saveNetBanking(String bankName, String userId);

	String addOrder(Customer customer, Address shippingAddress, PaymentMode paymentMode, Double total,
			LocalDateTime shippingDate, LocalDateTime orderDate, SupportedPaymentModesEnum mode);
}
