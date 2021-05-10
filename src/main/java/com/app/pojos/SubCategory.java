package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "sub_categories")
public class SubCategory extends BaseEntity {
	
	@Column(name = "sub_category_title", length = 100)
	private String subCTitle;
	
	@Column(name = "sub_category_status", length = 10)
	private String subStatus;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category parentCategory;

	public SubCategory() {
		System.out.println("In SubCategory Default Const");
	}

	public SubCategory(String subCTitle, String subStatus) {
		super();
		this.subCTitle = subCTitle;
		this.subStatus = subStatus;
	}
	

	public SubCategory(String subCTitle, String subStatus, Category parentCategory) {
		super();
		this.subCTitle = subCTitle;
		this.subStatus = subStatus;
		this.parentCategory = parentCategory;
	}
	

	public SubCategory(String subCTitle, Category parentCategory) {
		super();
		this.subCTitle = subCTitle;
		this.parentCategory = parentCategory;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public String getSubCTitle() {
		return subCTitle;
	}

	public void setSubCTitle(String subCTitle) {
		this.subCTitle = subCTitle;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	@Override
	public String toString() {
		return "SubCategory [subCTitle=" + subCTitle + ", subStatus=" + subStatus 
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((subCTitle == null) ? 0 : subCTitle.hashCode());
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
		SubCategory other = (SubCategory) obj;
		if (subCTitle == null) {
			if (other.subCTitle != null)
				return false;
		} else if (!subCTitle.equals(other.subCTitle))
			return false;
		return true;
	}
	

}