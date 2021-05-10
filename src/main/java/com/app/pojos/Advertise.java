package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "advertisement_list")
public class Advertise extends BaseEntity {
	@Column(name = "category_title", length = 50)
	private String cTitle;
	@Column(name = "add_status", length = 10)
	private String aStatus;
	@Lob
	@Column(name = "add_image")
	private byte[] aImage;

	@Transient
	private String imgUtility;
	public Advertise() {
		System.out.println("In Category Default Const");
	}

	public Advertise(String cTitle, String aStatus, byte[] aImage) {
		super();
		this.cTitle = cTitle;
		this.aStatus = aStatus;
		this.aImage = aImage;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getaStatus() {
		return aStatus;
	}

	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
	}

	public byte[] getaImage() {
		return aImage;
	}

	public void setaImage(byte[] aImage) {
		this.aImage = aImage;
	}


	//getter method for encoding
	public String getImgUtility() throws UnsupportedEncodingException {

       byte[] encodeBase64 = Base64.encodeBase64(getaImage());
       String base64Encoded = new String(encodeBase64, "UTF-8");              
       return base64Encoded;
	   }
	@Override
	public String toString() {
		return "Advertise [cTitle=" + cTitle + ", aStatus=" + aStatus + ", aImage=" + Arrays.toString(aImage) + "]";
	}

}
