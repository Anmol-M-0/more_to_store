package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "manufacture_info")
public class ManufactureInformation extends BaseEntity {
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate manufactureDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mfg_location_id")
	private Address manufactureLocation;
	private String manufactureInfo;
	private int warrenty;//warrenty provided by manufacturer no of yrs
	public ManufactureInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManufactureInformation(LocalDate manufactureDate, Address manufactureLocation, String manufactureInfo,
			int warrenty) {
		super();
		this.manufactureDate = manufactureDate;
		this.manufactureLocation = manufactureLocation;
		this.manufactureInfo = manufactureInfo;
		this.warrenty = warrenty;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Address getManufactureLocation() {
		return manufactureLocation;
	}
	public void setManufactureLocation(Address manufactureLocation) {
		this.manufactureLocation = manufactureLocation;
	}
	public String getManufactureInfo() {
		return manufactureInfo;
	}
	public void setManufactureInfo(String manufactureInfo) {
		this.manufactureInfo = manufactureInfo;
	}
	public int getWarrenty() {
		return warrenty;
	}
	public void setWarrenty(int warrenty) {
		this.warrenty = warrenty;
	}
	@Override
	public String toString() {
		return "ManufactureInformation [manufactureDate=" + manufactureDate + ", manufactureLocation="
				+ manufactureLocation + ", manufactureInfo=" + manufactureInfo + ", warrenty=" + warrenty + "]";
	}
	
	
	
	
	
}
