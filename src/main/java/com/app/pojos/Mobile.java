package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mobile")
public class Mobile extends Product {
	@OneToOne
	@JoinColumn(name="tech_details_id")
	private TechnicalDetails technicalDetails;
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
//constructor needs review
	

	public Mobile(TechnicalDetails technicalDetails) {
		super();
		this.technicalDetails = technicalDetails;
	}

	public TechnicalDetails getTechnicalDetails() {
		return technicalDetails;
	}

	public void setTechnicalDetails(TechnicalDetails technicalDetails) {
		this.technicalDetails = technicalDetails;
	}

	
	
	
	
	
}
//laptops and computers
//mobiles and smart devices, tablets, 
//hobby kits and electronics
//hardware and electricals
//software and games
//food and nutrition
//clothing - men women 
//shoes bags textiles
//beauty, sports and more
//home and living
//appliances