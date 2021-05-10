package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Upi extends PaymentDetails{

	@Column(name = "upi_mode",length = 50)
	private String upiMode;
	@Column(name = "upi_no",length = 50)
	private String upiNo;
	
	public Upi() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Upi(String upiMode, String upiNo) {
		super();
		this.upiMode = upiMode;
		this.upiNo = upiNo;
	}

	public String getUpiMode() {
		return upiMode;
	}

	public void setUpiMode(String upiMode) {
		this.upiMode = upiMode;
	}

	public String getUpiNo() {
		return upiNo;
	}

	public void setUpiNo(String upiNo) {
		this.upiNo = upiNo;
	}

	@Override
	public String toString() {
		return "Upi [upiMode=" + upiMode + ", upiNo=" + upiNo + "]";
	}
	
	
}
