package com.app.service;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductRepository;
import com.app.dao.WishlistItemRepository;
import com.app.exceptions.ProductNotFoundException;
import com.app.pojos.Customer;
import com.app.pojos.Product;
import com.app.pojos.Wishlist;
import com.app.pojos.WishlistItem;



@Service
@Transactional
public class WishlistServiceImpl implements IWishlistService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private WishlistItemRepository wishlistItemRepository;
	
	@Autowired
	private ICartService cartService;
	
	@Override
	public String addToWishList(Long pid, Customer customer) {
		if (pid == null)
			throw new ProductNotFoundException("product not found");
		Product product = productRepository.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException("product not found"));
		
		Wishlist wishlist = customer.getWishlist();
		Set<WishlistItem> wishlistItems = wishlist.getWishlistItems();
		//  long count = wishlistItems.stream().filter(ci->ci.getProduct().equals(product)).count();
		  Optional<WishlistItem> first = wishlistItems.stream().filter(ci->ci.getProduct().equals(product)).findFirst();
		  if(!first.isPresent()) {
			  WishlistItem wishlistItem = new WishlistItem();		
			  wishlistItem.setProduct(product);
			  wishlistItemRepository.save(wishlistItem);
			  wishlist.addItem(wishlistItem);
			  return "product successfully added to wishlist";
			
		  }
		return "product already in wishlist";
	}

	@Override
	public String moveToCart(Long pid, Customer customer) {//moves the item to cart
		
		if(pid==null)
			throw new ProductNotFoundException("product not found");
		Product product = productRepository.findById(pid)
							.orElseThrow(()->new ProductNotFoundException("product does not exist in the cart"));
		Wishlist wishlist = customer.getWishlist();
		Set<WishlistItem> wishlistItems = wishlist.getWishlistItems();
		wishlistItems.stream().filter(wi->wi.getProduct().equals(product))
				.peek(wi->{//is the item present in the cart?
					cartService.addToCart(wi.getProduct().getId(), customer);
					System.out.println("added item to cart");
					System.out.println(removeItemFromWishList(wi.getProduct().getId(), customer));
				})
				.count();
		return "moved to cart";
	}
	@Override
	public String removeItemFromWishList(Long pid, Customer customer) {
		if (pid == null)
			throw new ProductNotFoundException("product not found");
		System.out.println("in service "+pid);
		wishlistItemRepository.removeFromWishlist(pid, customer.getWishlist().getId());
		Wishlist wishlist = customer.getWishlist();
		Set<WishlistItem> wishlistItems = wishlist.getWishlistItems();
		wishlistItems.removeIf(p-> p.getProduct().getId().equals(pid));
		return "Item removed from wishlist";
	}
	
	@Override
	public Product getProduct(Long pid) {
		
		return productRepository.findById(pid)
				.orElseThrow(()->new ProductNotFoundException("product does not exist in the cart"));
	}

	
	
}
