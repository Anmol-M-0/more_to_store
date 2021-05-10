package com.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {

}
