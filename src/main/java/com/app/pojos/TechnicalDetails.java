package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "technical_details")
public class TechnicalDetails extends BaseEntity {
	@Column(length = 40)
	private String modelNo;
	@Column(length = 40)
	private String os;
	private double ram;
	@Column(length = 30)
	private String dimensions;
	private double batteryCapacity;
	@Column(length = 40)
	private String color;//white 
	@Column(length = 100)
	private String connectivity;
	@Column(length = 50)
	private String display;
	@Column(length = 100)
	private String camera;
	private double weight;
	@Column(length = 200)
	private String multimedia;
	@Column(length = 25)
	private String operatingFrequency;
	@Column(length = 25)
	private String resolution;
	public TechnicalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TechnicalDetails(String modelNo, String os, double ram, String dimensions, double batteryCapacity, String color,
			String connectivity, String display, String camera, double weight, String multimedia,
			String operatingFrequency, String resolution) {
		super();
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
	public double getRam() {
		return ram;
	}
	public void setRam(double ram) {
		this.ram = ram;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
	public double getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(double batteryCapacity) {
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
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
		return "TechnicalDetails [modelNo=" + modelNo + ", os=" + os + ", ram=" + ram + ", dimensions=" + dimensions
				+ ", batteries=" + batteryCapacity + ", color=" + color + ", connectivity=" + connectivity + ", display="
				+ display + ", camera=" + camera + ", weight=" + weight + ", multimedia=" + multimedia
				+ ", operatingFrequency=" + operatingFrequency + ", resolution=" + resolution + "]";
	}
	
	
	
	
	

}
