package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	@Modifying
	@Query(nativeQuery = true, value = "update order_item set product_id = :pid where id = :oid")
	void addProduct(Long pid, Integer oid);

}
