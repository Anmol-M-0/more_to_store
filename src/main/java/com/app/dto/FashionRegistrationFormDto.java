package com.app.dto;

import com.app.pojos.Address;
import com.app.pojos.Description;
import com.app.pojos.Fashion;
import com.app.pojos.ManufactureInformation;
import com.app.pojos.Misc;

public class FashionRegistrationFormDto {

	private Fashion fashionInfo;
	private Description description;
	private ManufactureInformation manufactureInformation;
	private Address address;
	public FashionRegistrationFormDto() {
		System.out.println("in fashion dto");
	}


	public FashionRegistrationFormDto(Fashion fashionInfo, Description description,
			ManufactureInformation manufactureInformation, Address address) {
		super();
		this.fashionInfo = fashionInfo;
		this.description = description;
		this.manufactureInformation = manufactureInformation;
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Fashion getFashionInfo() {
		return fashionInfo;
	}

	public void setFashionInfo(Fashion fashionInfo) {
		this.fashionInfo = fashionInfo;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public ManufactureInformation getManufactureInformation() {
		return manufactureInformation;
	}

	public void setManufactureInformation(ManufactureInformation manufactureInformation) {
		this.manufactureInformation = manufactureInformation;
	}


	@Override
	public String toString() {
		return "FashionRegistrationFormDto [fashionInfo=" + fashionInfo + ", description=" + description
				+ ", manufactureInformation=" + manufactureInformation + ", address=" + address + "]";
	}

	
	
}
