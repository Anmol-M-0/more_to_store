package com.app.service;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CartItemRepository;
import com.app.dao.CartRepository;
import com.app.dao.ProductRepository;
import com.app.exceptions.CartitemException;
import com.app.exceptions.ProductNotFoundException;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.Product;

@Service
@Transactional
public class CartServiceImpl implements ICartService{


	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private IWishlistService wishlistService;
	
	@Autowired
	private CartRepository cartRepository;
	@Override
	public String saveForLater(Long pid, Customer customer) {//cart to wishlist
		if (pid == null)
			throw new ProductNotFoundException("product not found");
		Product product = productRepository.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException("product not found"));
		
		Cart cart = customer.getCart();
		Set<CartItem> cartItems = cart.getCartItems();
		cartItems.stream().filter(c->c.getProduct().equals(product)).forEach(ci -> {
			wishlistService.addToWishList(ci.getProduct().getId(), customer);
			removeFromCart(ci.getProduct().getId(), customer);
		});
		return "moved the item to wishlist";
	}
	@Override
	public String addToCart(Long pid, Customer customer) {// use native query for better performance
															//cart quantity not getting updated
		if (pid == null)
			throw new ProductNotFoundException("product not found");
		
		Product product = productRepository.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException("product not found"));
		System.out.println("title "+product.getTitle());
		System.out.println(product);
		Cart cart = customer.getCart();
		Set<CartItem> cartItems = cart.getCartItems();//this is lazy
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		//equals not working for cartItem for some reason inside filter
		//so used product instead
		long count = cartItems.stream().filter(ci->ci.getProduct().equals(product))
						.peek(i->increaseCartitemQtyByOne(i.getProduct().getId(), customer))
						.count();
		if(count == 0){
			cartItem.setQuantity(1);
			cartItemRepository.save(cartItem);
			cart.addItem(cartItem);
			return "product successfully added to cart";
		}
		return "quantity of the product increased by one";
	}
	
	@Override
	public String increaseCartitemQtyByOne(Long pid, Customer customer) {
		return increaseCartitemQty(pid, customer, 1);
	}
	@Override
	public String increaseCartitemQty(Long pid, Customer customer, int incr) {
		Optional<CartItem> findFirst = customer.getCart().getCartItems().stream().filter(ci->ci.getProduct().getId().equals(pid)).findFirst();
		if(findFirst.get().getQuantity()>=10) 
			return "the quantity is already max";
		
		int count  = cartItemRepository.increaseCartitemQuantity(pid, customer.getCart().getId(), incr);
		if(count==0)  
			throw new CartitemException("the item is not present in the cart");
		
		
		if(count==0)  
			throw new CartitemException("the item is not present in the cart");
		for(CartItem ci : customer.getCart().getCartItems() ) {
			if(ci.getProduct().getId().equals(pid)){
				ci.setQuantity(ci.getQuantity()+incr);
			}
		}
		return "cart item qty increased by "+incr;
	}
	
	@Override
	public String setCartitemQty(Long pid, Customer customer, int quantity) {
		if(quantity>= 10)
			quantity = 10;
		int count = cartItemRepository.setCartitemQuantity(pid, customer.getCart().getId(), quantity);
		if(count==0)  
			throw new CartitemException("the item is not present in the cart");
		for(CartItem ci : customer.getCart().getCartItems()) {
			if(ci.getProduct().getId().equals(pid)) {
				ci.setQuantity(quantity);
				System.out.println(" changing the quantity  of the cart item in java ");
			}
		}
		return "item quantity set to "+quantity;
	}
	@Override
	public String setCartitemQtyToOne(Long pid, Customer customer) {
		return setCartitemQty(pid, customer, 1);
	}
	
	@Override
	public String decreaseCartitemQuantity(Long pid, Customer customer, int decr) {//handle the case where the qty goes to -ve
		int count = cartItemRepository.decreaseCartitemQty(pid, customer.getCart().getId(), decr);
		
		if(count==0)  
			throw new CartitemException("the item is not present in the cart");
		for(CartItem ci : customer.getCart().getCartItems()) {
			if(ci.getProduct().getId().equals(pid)) {
				ci.setQuantity(ci.getQuantity()-1);
				System.out.println(" changing the quantity  of the cart item in java ");
			}
		}
		return "item quantity decreased by "+decr;
	}
	@Override
	public String decreaseCartitemQtyByOne(Long pid, Customer customer) {
		return decreaseCartitemQuantity(pid, customer, 1);
	}
	@Override
	public String removeFromCart(Long pid, Customer customer) {
		int count = cartItemRepository.removeFromCart(pid, customer.getCart().getId());
		if(count == 0)
			throw new CartitemException("the item is not present in the cart");
		customer.getCart().getCartItems().removeIf(ci->ci.getProduct().getId().equals(pid));
		return "item removed from cart";
	}
	@Override
	public void deleteCart(Customer customer) {
		cartItemRepository.deleteCartItems(customer.getCart().getId());
		customer.getCart().setCartItems(cartItemRepository.findAllItems(customer.getCart()));
	}
	
}
