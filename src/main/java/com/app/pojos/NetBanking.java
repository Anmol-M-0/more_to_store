package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class NetBanking extends PaymentMode {
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "user_id" , length = 100)
	private String userId;
	
	public NetBanking() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	public NetBanking(String bankName, String userId) {
		super();
		this.bankName = bankName;
		this.userId = userId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "NetBanking [bankName=" + bankName + ", userId=" + userId + "]";
	}
	
}
