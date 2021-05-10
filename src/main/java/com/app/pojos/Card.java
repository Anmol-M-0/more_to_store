package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Card extends PaymentMode{
	@Column(length = 16, nullable = false, unique = true)
	private String cardNo;
	@Column(length = 50)
	private String cardHolderName;
	@Column(length = 50)
	private String expYear;
	@Column(length = 50)
	private String expMonth;
	
	private int cvv;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Card(String cardNo, String cardHolderName, String expYear, String expMonth, int cvv) {
		super();
		this.cardNo = cardNo;
		this.cardHolderName = cardHolderName;
		this.expYear = expYear;
		this.expMonth = expMonth;
		this.cvv = cvv;
	}

	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", cardHolderName=" + cardHolderName + ", expYear=" + expYear + ", expMonth="
				+ expMonth + ", cvv=" + cvv + "]";
	}	
}
