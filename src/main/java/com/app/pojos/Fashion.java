package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fashion")
public class Fashion extends Product {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fashion_details_tbl")
	private FashionDetails fashionDetails;

	public Fashion() {
		super();
	}

	public Fashion(FashionDetails fashionDetails) {
		super();
		this.fashionDetails = fashionDetails;
	}

	public FashionDetails getFashionDetails() {
		return fashionDetails;
	}

	public void setFashionDetails(FashionDetails fashionDetails) {
		this.fashionDetails = fashionDetails;
	}
	
}
