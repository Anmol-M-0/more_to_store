package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Wishlist extends BaseEntity {

	@OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<WishlistItem> wishlistItems = new HashSet<>();//one to many
	public Wishlist(Set<WishlistItem> wishlistItems) {
		super();
		this.wishlistItems = wishlistItems;
	}
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Set<WishlistItem> getWishlistItems() {
		return wishlistItems;
	}
	public void setWishlistItems(Set<WishlistItem> wishlistItems) {
		this.wishlistItems = wishlistItems;
	}
	public void addItem(WishlistItem item) {
		wishlistItems.add(item);
		item.setWishlist(this);
		
	}
	public void removeItem(WishlistItem item) {
		wishlistItems.remove(item);
		item.setWishlist(null);
	}
	@Override
	public String toString() {
		return "Wishlist ["+" wishlistItems=" + wishlistItems + "]";
	}
	
	
	

}
