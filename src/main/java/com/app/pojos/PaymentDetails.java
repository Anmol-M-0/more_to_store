package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class PaymentDetails extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private SupportedPaymentModesEnum selectedMode;//in db table shows what payment mode has been used
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime paymentDate;
	
	private double paymentAmount;
	
	@Column(length = 15)
	private String paymentStatus;//success or fail
	
	@OneToOne
	@JoinColumn(name = "payment_mode_id")
	private PaymentMode paymentMode;

	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDetails(SupportedPaymentModesEnum selectedMode, LocalDateTime paymentDate, double paymentAmount,
			String paymentStatus, PaymentMode paymentMode) {
		super();
		this.selectedMode = selectedMode;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
	}

	public SupportedPaymentModesEnum getSelectedMode() {
		return selectedMode;
	}

	public void setSelectedMode(SupportedPaymentModesEnum selectedMode) {
		this.selectedMode = selectedMode;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "PaymentDetails [selectedMode=" + selectedMode + ", paymentDate=" + paymentDate + ", paymentAmount="
				+ paymentAmount + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	

}
