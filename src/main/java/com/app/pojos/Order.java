package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name = "order_tbl")
public class Order extends BaseEntity {
	
	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItems = new HashSet<>();//one to many, fetch eager?
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;// one to one
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime orderDate;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate shippingDate;//15 days, need more considerations, logistics not defined

	private Double total;//total bill
	@OneToOne
	@JoinColumn(name = "payment_details_id")
	private PaymentDetails paymentDetails;
	
	@OneToOne 
	@JoinColumn(name = "address_id")
	private ShippingAddress address;//not Address class, but ShippingAddress class instead
	
	
	@Column(length = 15)
	private String orderStatus;//active, old, cancelled

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Set<OrderItem> orderItems, Customer customer, LocalDateTime orderDate, LocalDate shippingDate,
			Double total, PaymentDetails paymentDetails, ShippingAddress address) {
		super();
		this.orderItems = orderItems;
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.total = total;
		this.paymentDetails = paymentDetails;
		this.address = address;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(LocalDate shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public ShippingAddress getAddress() {
		return address;
	}

	public void setAddress(ShippingAddress address) {
		this.address = address;
	}
	public void addOrderItem(OrderItem orderItem) {
		orderItem.setOrder(this);
		this.orderItems.add(orderItem);
	}
	public void removeOrderItem(OrderItem orderItem) {
		this.orderItems.remove(orderItem);
		orderItem.setOrder(null);
	}
	
	@Override
	public String toString() {
		return "Order [customer=" + customer + ", dateOfOrder=" + orderDate + ", shippingDate=" + shippingDate
				+ ", total=" + total + ", address=" + address + "]";
	}
	
	
	
	
	
	
	

}
