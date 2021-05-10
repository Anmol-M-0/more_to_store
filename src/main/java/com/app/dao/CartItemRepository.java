package com.app.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Cart;
import com.app.pojos.CartItem;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	@Modifying
	@Query(nativeQuery = true, value = "update cart_item set quantity=quantity+1 where cart_id =:cartId and product_id=:productId")
	int incrementQuantityByOne(@Param("cartId")int cartId,@Param("productId") Long productId);
	
	@Modifying
	@Query(nativeQuery = true, value = "update cart_item set quantity = quantity + :i where cart_id = :id and product_id = :pid")
	int increaseCartitemQuantity(@Param("pid")Long pid, @Param("id")Integer id, @Param("i") int i);
	
	
	@Modifying
	@Query(nativeQuery = true, value = "update cart_item set quantity = :quantity where cart_id = :id and product_id = :pid")
	int setCartitemQuantity(@Param("pid")Long pid, @Param("id")Integer id,@Param("quantity") int quantity);
	
	
	@Modifying
	@Query(nativeQuery = true, value = "update cart_item set quantity = quantity - :decr where cart_id = :id and product_id = :pid")
	int decreaseCartitemQty(@Param("pid")Long pid, @Param("id")Integer id, int decr);

	@Modifying
	@Query(nativeQuery = true, value = "delete from cart_item where cart_id = :id and product_id = :pid")
	int removeFromCart(@Param("pid")Long pid, @Param("id")Integer id);

	@Query(nativeQuery = true, value = "select product_id from cart_item where cart_id = :cid")
	Set<Integer> getProductIds(@Param("cid")Integer cid);
	@Modifying
	@Query(nativeQuery = true, value = "delete from cart_item where cart_id=:id")
	void deleteCartItems(@Param("id")Integer id);
	@Query("select c from CartItem c where c.cart=:cart")
	Set<CartItem> findAllItems(@Param("cart")Cart cart);

	
}
