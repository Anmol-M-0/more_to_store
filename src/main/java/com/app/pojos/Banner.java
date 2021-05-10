package com.app.pojos;

import java.io.UnsupportedEncodingException;

import javax.persistence.*;

import org.apache.tomcat.util.codec.binary.Base64;



@Entity
@Table(name="banner_list")
public class Banner extends BaseEntity{
	
	@Column(name = "banner_category_id")
	private String bannerCategory;
	
	@Column(name = "banner_status", length = 20)
	private String bannerStatus;
	
	@Lob
	@Column(name = "banner_image")
	private byte[] bannerImage;
	   
	@Transient
	private String imgUtility;

	public Banner() {
		System.out.println("in banner default const ");
	}

	public Banner(String title,String bannerStatus, byte[] bannerImage) {
		super();
		this.bannerCategory=title;
		this.bannerStatus = bannerStatus;
		this.bannerImage = bannerImage;
	}

	public String getBannerCategory() {
		return bannerCategory;
	}

	public void setBannerCategory(String bannerCategory) {
		this.bannerCategory = bannerCategory;
	}

	public String getBannerStatus() {
		return bannerStatus;
	}

	public void setBannerStatus(String bannerStatus) {
		this.bannerStatus = bannerStatus;
	}

	public byte[] getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(byte[] bannerImage) {
		this.bannerImage = bannerImage;
	}

	//getter method for encoding
	public String getImgUtility() throws UnsupportedEncodingException {

       byte[] encodeBase64 = Base64.encodeBase64(getBannerImage());
       String base64Encoded = new String(encodeBase64, "UTF-8");              
       return base64Encoded;
	   }

	@Override
	public String toString() {
		return "Banner [bannerStatus=" + bannerStatus;
	}
}
