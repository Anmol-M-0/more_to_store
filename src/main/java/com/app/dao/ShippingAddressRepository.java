package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.ShippingAddress;
@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer>{

}
