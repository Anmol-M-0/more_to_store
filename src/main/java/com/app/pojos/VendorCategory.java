package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_category_tbl")
public class VendorCategory extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "vendor_id", nullable = false)
	private Vendor vendorDetails;
	@Column(name = "category_title",nullable = false)
	private String categoryTitle;
	
	public VendorCategory() {
		super();
	}
	

	public VendorCategory(String categoryTitle) {
		super();
		this.categoryTitle = categoryTitle;
	}
	public Vendor getVendorDetails() {
		return vendorDetails;
	}
	public void setVendorDetails(Vendor vendorDetails) {
		this.vendorDetails = vendorDetails;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	@Override
	public String toString() {
		return "VendorCategory ["+ ", categoryTitle=" + categoryTitle + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((categoryTitle == null) ? 0 : categoryTitle.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorCategory other = (VendorCategory) obj;
		if (categoryTitle == null) {
			if (other.categoryTitle != null)
				return false;
		} else if (!categoryTitle.equals(other.categoryTitle))
			return false;
		return true;
	}
	

}
