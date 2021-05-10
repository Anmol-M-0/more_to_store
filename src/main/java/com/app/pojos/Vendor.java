package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "vendor_tbl")
public class Vendor extends BaseEntity {
	@Column(name = "full_name" , length = 50)
	private String fullName;//yes
	@Column(name = "vendor_email", length = 50, unique = true)
	private String email;//no
	@Column(name = "vendor_password", length = 50)
	private String password;//yes
	@Column(name = "vendor_mobile_no", length = 13, unique = true)
	private String mobileNo;//no
	@Column(name = "shop_name" , length = 50)
	private String shopName;//yes
	@Column(name = "registration_no" , length = 50)
	private String regNo;//no
	@Column(name = "status" , length = 50)
	private String status;//no
//	private List<VendorCategory> vendorCategory = new ArrayList<>();//in which subCategory do the products that vendor is going to sell belong to?
//=>Set<SubCategories> onetomany unidirn, in parent side
	@OneToMany(mappedBy = "vendorDetails", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VendorCategory> vendorCategory = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_address_id")
    private Address vendorAddress;//yes
	
	//product
	@ManyToMany(mappedBy = "vendors",cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<>();
		
	public Vendor() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Vendor(String fullName, String email, String password, String mobileNo, String shopName, String regNo,
			String status) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.shopName = shopName;
		this.regNo = regNo;
		this.status = status;
		
	}
	
	
	public void addProduct(Product product) {
		this.products.add(product);
		product.getVendors().add(this);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
		product.getVendors().remove(this);
	}
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<VendorCategory> getVendorCategory() {
		return vendorCategory;
	}

	public void setVendorCategory(Set<VendorCategory> vendorCategory) {
		this.vendorCategory = vendorCategory;
	}

	public Address getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(Address vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	@Override
	public String toString() {
		return "Vendor [fullName=" + fullName + ", email=" + email + ", password=" + password + ", mobileNo=" + mobileNo
				+ ", shopName=" + shopName + ", regNo=" + regNo + ", status=" + status + ", vendorCategory="
				+ vendorCategory + ", vendorAddress=" + vendorAddress + "]";
	}
	
}	
	
	

	

	