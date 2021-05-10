package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fashion_details")
public class FashionDetails extends BaseEntity {

	@Column(length = 30)
	private String fashionType;
	
	@Column(length=50)
	private String color;
	
	@Column(length=20)
	private String size;
	
	@Column(length=50)
	private String type;
	
	@Column(length = 50)
	private String sleeve;
	
	
	@Column(length = 50)
	private String idealFor;

	@Column(length = 100)
	private String pattern;
	
	@Column(length = 100)
	private String modelName;
	
	@Column(length = 100)
	private String material;
	
	@Column(length = 100)
	private String occasion;

	public FashionDetails() {
		super();
	}

	public FashionDetails(String color, String size, String type, String sleeve, String idealFor,
			String pattern, String modelName, String material, String occasion) {
		super();
		this.color = color;
		this.size = size;
		this.type = type;
		this.sleeve = sleeve;
		this.idealFor = idealFor;
		this.pattern = pattern;
		this.modelName = modelName;
		this.material = material;
		this.occasion = occasion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSleeve() {
		return sleeve;
	}

	public void setSleeve(String sleeve) {
		this.sleeve = sleeve;
	}

	public String getIdealFor() {
		return idealFor;
	}

	public void setIdealFor(String idealFor) {
		this.idealFor = idealFor;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
	this.occasion = occasion;
	}

	public String getFashionType() {
		return fashionType;
	}

	public void setFashionType(String fashionType) {
		this.fashionType = fashionType;
	}

	@Override
	public String toString() {
		return "FashionDetails [color=" + color + ", size=" + size + ", type=" + type + ", sleeve=" + sleeve
				 +", idealFor=" + idealFor + ", pattern=" + pattern + ", modelName=" + modelName
				+ ", material=" + material + ", occasion=" + occasion + "]";
	}
	
	
	
}
