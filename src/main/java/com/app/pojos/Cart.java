package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;




@Entity
public class Cart extends BaseEntity {
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
//	@Cascade(value = {CascadeType.SAVE_UPDATE})
	private Set<CartItem> cartItems = new HashSet<>();//one to many, fetch eager?
	
	

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Cart(Set<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	

	
	public void addItem(CartItem item) {
		cartItems.add(item);
		item.setCart(this);
		
	}
	public void removeItem(CartItem item) {
		cartItems.remove(item);
		item.setCart(null);
	}
	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + "]";
	}
	
	
	
	
	

}
