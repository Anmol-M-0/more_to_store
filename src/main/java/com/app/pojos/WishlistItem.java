package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WishlistItem extends BaseEntity {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;//unidirectional one to one
	@ManyToOne
	@JoinColumn(name = "wishlist_id")
	private Wishlist wishlist;
	public WishlistItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishlistItem( Product product, Wishlist wishlist) {
		super();
		this.product = product;
		this.wishlist = wishlist;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Wishlist getWishlist() {
		return wishlist;
	}
	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		WishlistItem other = (WishlistItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WishlistItem ["+"product=" + product + "]";
	}
	
}
