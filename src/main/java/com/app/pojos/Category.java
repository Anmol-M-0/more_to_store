package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "main_categories")
public class Category extends BaseEntity {
	@Column(name = "category_title", length = 50)
	private String cTitle;
	@Column(name = "category_status", length = 10)
	private String cStatus;
	@Lob
	@Column(name = "category_image")
	private byte[] cImage;
	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubCategory> subCategories = new ArrayList<>();

	@Transient
	private String imgUtility;
	public Category() {
		System.out.println("In Category Default Const");
	}

	public Category(String cTitle, String cStatus, byte[] cImage) {
		super();
		this.cTitle = cTitle;
		this.cStatus = cStatus;
		this.cImage = cImage;
	}

	public String getcStatus() {
		return cStatus;
	}

	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}

	public byte[] getcImage() {
		return cImage;
	}

	public void setcImage(byte[] cImage) {
		this.cImage = cImage;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	//getter method for encoding
		public String getImgUtility() throws UnsupportedEncodingException {

	       byte[] encodeBase64 = Base64.encodeBase64(getcImage());
	       if(encodeBase64 == null)
		    	return "";
	       String base64Encoded = new String(encodeBase64, "UTF-8");              
	       return base64Encoded;
		   }


	@Override
	public String toString() {
		return "Category [cTitle=" + cTitle + ", cStatus=" + cStatus + ", cImage=" + "]";
	}


}
