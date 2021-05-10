package com.app.dto;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.app.pojos.Address;
import com.app.pojos.Description;


public class MobileRegisterationFormDTO {
	private String stock;
	private String brand;
	private String name;
	private String title;
	private String price;
	private String offer;//percentage
	private Description description;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate manufactureDate;
	private Address manufactureLocation;
	private String pincode;//add this to mfg location separately
	private String manufactureInfo;
	private String warrenty;
//	private List<ProductImage> images = new ArrayList<>();
//	private ManufactureInformation manufactureInformation;
	
	
	//technical details;
	private String modelNo;
	private String os;
	private String ram;
	private String dimensions;
	private String batteryCapacity;
	private String color;//white 
	private String connectivity;
	private String display;
	private String camera;
	private String weight;
	private String multimedia;
	private String operatingFrequency;
	private String resolution;
	
	public MobileRegisterationFormDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MobileRegisterationFormDTO(String stock, String brand, String name, String title, String price, String offer,
			Description description, LocalDate manufactureDate, Address manufactureLocation, String pincode,
			String manufactureInfo, String warrenty, String modelNo, String os, String ram, String dimensions,
			String batteryCapacity, String color, String connectivity, String display, String camera, String weight,
			String multimedia, String operatingFrequency, String resolution) {
		super();
		this.stock = stock;
		this.brand = brand;
		this.name = name;
		this.title = title;
		this.price = price;
		this.offer = offer;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.manufactureLocation = manufactureLocation;
		this.pincode = pincode;
		this.manufactureInfo = manufactureInfo;
		this.warrenty = warrenty;
		this.modelNo = modelNo;
		this.os = os;
		this.ram = ram;
		this.dimensions = dimensions;
		this.batteryCapacity = batteryCapacity;
		this.color = color;
		this.connectivity = connectivity;
		this.display = display;
		this.camera = camera;
		this.weight = weight;
		this.multimedia = multimedia;
		this.operatingFrequency = operatingFrequency;
		this.resolution = resolution;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getManufactureInfo() {
		return manufactureInfo;
	}

	public void setManufactureInfo(String manufactureInfo) {
		this.manufactureInfo = manufactureInfo;
	}

	public String getWarrenty() {
		return warrenty;
	}

	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(String multimedia) {
		this.multimedia = multimedia;
	}

	public String getOperatingFrequency() {
		return operatingFrequency;
	}

	public void setOperatingFrequency(String operatingFrequency) {
		this.operatingFrequency = operatingFrequency;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "MobileRegisterationFormDTO [stock=" + stock + ", brand=" + brand + ", name=" + name + ", title=" + title
				+ ", price=" + price + ", offer=" + offer + ", description=" + description + ", manufactureDate="
				+ manufactureDate + ", manufactureLocation=" + manufactureLocation + ", pincode=" + pincode
				+ ", manufactureInfo=" + manufactureInfo + ", warrenty=" + warrenty + ", modelNo=" + modelNo + ", os="
				+ os + ", ram=" + ram + ", dimensions=" + dimensions + ", batteryCapacity=" + batteryCapacity
				+ ", color=" + color + ", connectivity=" + connectivity + ", display=" + display + ", camera=" + camera
				+ ", weight=" + weight + ", multimedia=" + multimedia + ", operatingFrequency=" + operatingFrequency
				+ ", resolution=" + resolution + "]";
	}
	
	
	
	
}
