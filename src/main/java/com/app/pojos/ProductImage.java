package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;



@Entity
@Table(name = "product_images_tbl")
public class ProductImage extends BaseEntity {
	@Lob
	@Column(length = 5000000)
	private byte[] image;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;


	@Transient
	private String imgUtility;

	public String getImgUtility() throws UnsupportedEncodingException {

		byte[] encodeBase64 = Base64.encodeBase64(getImage());
		if(encodeBase64 == null)
	    	return "";
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ProductImage(byte[] image, Product product) {
		super();
		this.image = image;
		this.product = product;
	}

	public ProductImage(byte[] image, String imgUtility) {
		super();
		this.image = image;
		this.imgUtility = imgUtility;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(image);
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
		ProductImage other = (ProductImage) obj;
		if (!Arrays.equals(image, other.image))
			return false;
		return true;
	}
	
	
	

}
