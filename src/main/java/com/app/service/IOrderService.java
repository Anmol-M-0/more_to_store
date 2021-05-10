package com.app.service;

import java.time.LocalDateTime;

import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.Order;
import com.app.pojos.OrderItem;
import com.app.pojos.PaymentMode;
import com.app.pojos.Product;
import com.app.pojos.SupportedPaymentModesEnum;

public interface IOrderService {


	Order saveOrder(Customer customer, Address shippingAddress, PaymentMode paymentMode, Double total,
			LocalDateTime shippingDate, LocalDateTime orderDate, SupportedPaymentModesEnum mode);
	void saveOrderItem(int quantity, Product product, Order order);
	
	Order createNewOrder(Customer customer, Address shippingAddress, LocalDateTime orderDate,
			LocalDateTime shippingDate, Double total, PaymentMode paymentMode, SupportedPaymentModesEnum mode);

}
