package com.app.service;

import static com.app.utils.OrderUtil.ACTIVE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.dao.CartRepository;
import com.app.dao.CustomerRepository;
import com.app.dao.OrderItemRepository;
import com.app.dao.OrderRepository;
import com.app.dao.ProductRepository;
import com.app.dao.ShippingAddressRepository;
import com.app.pojos.Address;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.Order;
import com.app.pojos.OrderItem;
import com.app.pojos.PaymentDetails;
import com.app.pojos.PaymentMode;
import com.app.pojos.Product;
import com.app.pojos.ShippingAddress;
import com.app.pojos.SupportedPaymentModesEnum;
import static com.app.utils.OrderUtil.*;
import static com.app.pojos.SupportedPaymentModesEnum.*;
@Transactional
@Service
public class OrderServiceImpl implements IOrderService {// role based auth

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private ICartService cartService;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;
	
	/*
	 * 1.create the order object 2. save the order object 3. fetch items form cart one by
	 * one 4. add the cart items to order items 5. set inside the order object 6. delete all
	 * the cart items, or, alternatively delete the cart
	 * 
	 */
	@Override
	public Order saveOrder(Customer customer, Address shippingAddress, PaymentMode paymentMode, Double total,
			LocalDateTime shippingDate, LocalDateTime orderDate, SupportedPaymentModesEnum mode) {
		System.out.println("step 1");
		Order order = createNewOrder(customer, shippingAddress, orderDate, shippingDate, total, paymentMode, mode);// step 1, 2
		System.out.println("step 2");
		Set<CartItem> cartItems = customer.getCart().getCartItems();
		cartItems.forEach(ci -> saveOrderItem(ci.getQuantity(), ci.getProduct(), order));
		System.out.println("step 3");
		// remove cart?
		cartService.deleteCart(customer);
		System.out.println("step 4");
		Set<Order> orders = customer.getOrders();
		orders.add(order);
		System.out.println("step 5");
		
		return order;
	}

	@Override
	public Order createNewOrder(Customer customer, Address shippingAddress, LocalDateTime orderDate, 
			LocalDateTime shippingDate, Double total, PaymentMode paymentMode, SupportedPaymentModesEnum mode) {
		System.out.println("in step 1");
		Order order = new Order();
		shippingAddress = addressRepository.save(shippingAddress);
		ShippingAddress shippingAddress2 = new ShippingAddress(shippingAddress, customer.getAdditionalDetails());
		shippingAddressRepository.save(shippingAddress2);
		order.setAddress(shippingAddress2);
		order.setOrderStatus(ACTIVE);
		order.setCustomer(customer);
		order.setOrderDate(orderDate);
		LocalDate sd = shippingDate.toLocalDate();
		order.setShippingDate(sd);
		order.setTotal(total);
		PaymentDetails paymentDetails = new PaymentDetails(mode, LocalDateTime.now(), total, SUCCESS, paymentMode);
		
		paymentDetailsRepository.save(paymentDetails);
		order.setPaymentDetails(paymentDetails);
		System.out.println("step 1 end");
		return orderRepository.save(order);
	}

	@Override
	public void saveOrderItem(int quantity, Product product, Order order) {
		System.out.println("in step 2 ");
		OrderItem orderItem = new OrderItem();
		System.out.println(product);
//		orderItem.setProduct(product);
		
		System.out.println("step 2.5");
		orderItem.setQuantity(quantity);
		System.out.println("step 2.6");
		System.out.println(orderItem.getId());
		orderItem = orderItemRepository.save(orderItem);
		System.out.println("step 2.7");
		order.addOrderItem(orderItem);
		System.out.println(orderItem.getId());
		orderItemRepository.addProduct(product.getId(), orderItem.getId());
		System.out.println("order item added to the order successfully");
		System.out.println("step 2 end");
	}

}
