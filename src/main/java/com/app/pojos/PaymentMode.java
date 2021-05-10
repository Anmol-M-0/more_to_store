package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PaymentMode {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "IdGenerator")
	@TableGenerator(name = "IdGenerator")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "addn_details_id")
	private AdditionalDetails additionalDetails;//Many to one

	public PaymentMode() {
		super();
	}

	public PaymentMode(Long id, AdditionalDetails additionalDetails) {
		super();
		this.id = id;
		this.additionalDetails = additionalDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdditionalDetails getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(AdditionalDetails additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	@Override
	public String toString() {
		return "PaymentMode [id=" + id + "]";
	}
	
	
	
	
	
}
