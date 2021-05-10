package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.WishlistItem;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Integer> {
	@Modifying
	@Query(nativeQuery = true, value = "update wishlist_item set quantity=quantity+1 where wishlist_id =:wishlistId and product_id=:productId")
	int incrementQuantityByOne(@Param("wishlistId") int wishlistId,@Param("productId") Long productId);
	@Modifying
	@Query(nativeQuery = true, value = "delete from wishlist_item where wishlist_id =:id and product_id=:pid")
	int removeFromWishlist(@Param("pid")Long pid, @Param("id")Integer id);
}
