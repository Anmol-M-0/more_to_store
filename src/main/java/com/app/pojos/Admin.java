package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin_tbl")
public class Admin extends BaseEntity {
	@Column(name = "admin_name", length = 50)
	private String name;
	@Column(name = "admin_email", length = 50, unique = true)
	private String email;
	@Column(name = "admin_password", length = 50)
	private String password;
	@Column(name = "admin_mobile_no", length = 13, unique = true)
	private String mobileNo;
	@Column(name = "admin_address",length = 255)
	private String address;
	
	public Admin() {
		System.out.println("in Admin Pojo default constrs");
	}

	public Admin(String name, String email, String password, String mobileNo, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", email=" + email + ", password=" + password + ", mobileNo=" + mobileNo
				+ ", address=" + address + "]";
	}
	
}
