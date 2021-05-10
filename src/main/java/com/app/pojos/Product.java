package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product{

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "IdGenerator")
	@TableGenerator(name = "IdGenerator")
	private Long id;
	@Column(length = 10)
	private String status;
	private int stock;
	@Column(length = 100)
	private String brand;
	@Column(length = 140)
	private String name;
	private String title;
	private double price;
	private double offer;//percentage
	private LocalDate dateAdded;//loc.now()
	@Lob
	@Column(name = "product_image")
	private byte[] pImage;
	@Transient
	private String imgUtility;
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "description_id")
	private Description description;
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "misc_id")
	private Misc misc;
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "mfg_id")
	private ManufactureInformation manufactureInformation;
	

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "product_vendor",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name="vendor_id"))
	private Set<Vendor> vendors = new HashSet<>();
	
	@OneToMany(mappedBy = "product",orphanRemoval = true, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.EAGER)
	private List<ProductImage> images = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "vendor_category_id")
	private VendorCategory productCategory;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int stock, String brand, String name, String title, double price, double offer,
			Description description, Misc misc, ManufactureInformation manufactureInformation, LocalDate dateAdded,
			Set<Vendor> vendors, List<ProductImage> images) {
		super();
		this.stock = stock;
		this.brand = brand;
		this.name = name;
		this.title = title;
		this.price = price;
		this.offer = offer;
		this.description = description;
		this.misc = misc;
		this.manufactureInformation = manufactureInformation;
		this.dateAdded = dateAdded;
		this.vendors = vendors;
		this.images = images;
	}
	
	public void addVendor(Vendor vendor) {
		this.vendors.add(vendor);
		vendor.getProducts().add(this);
	}
	public void removeVendor(Vendor vendor) {
		this.vendors.remove(vendor);
		vendor.getProducts().remove(this);
	}
	
	
	public VendorCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(VendorCategory productCategory) {
		this.productCategory = productCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public Misc getMisc() {
		return misc;
	}
	public void setMisc(Misc misc) {
		this.misc = misc;
	}
	public ManufactureInformation getManufactureInformation() {
		return manufactureInformation;
	}
	public void setManufactureInformation(ManufactureInformation manufactureInformation) {
		this.manufactureInformation = manufactureInformation;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Set<Vendor> getVendors() {
		return vendors;
	}
	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}
	
	
	public List<ProductImage> getImages() {
		return images;
	}
	public void setImages(List<ProductImage> images) {
		this.images = images;
	}
	
	public byte[] getpImage() {
		return pImage;
	}
	public void setpImage(byte[] pImage) {
		this.pImage = pImage;
	}
	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Product other = (Product) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public String getImgUtility() throws UnsupportedEncodingException {

	       byte[] encodeBase64 = Base64.encodeBase64(getpImage());
	       if(encodeBase64 == null)
		    	return "";
	       String base64Encoded = new String(encodeBase64, "UTF-8");              
	       return base64Encoded;
		   }
	@Override
	public String toString() {
		return "Product [stock=" + stock + ", brand=" + brand + ", name=" + name + ", title=" + title + ", price="
				+ price + ", offer=" + offer + ", dateAdded=" + dateAdded + "]";
	}
	
	
	
	
	
	
	
}
