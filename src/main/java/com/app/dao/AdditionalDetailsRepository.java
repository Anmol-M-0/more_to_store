package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.AdditionalDetails;

@Repository
public interface AdditionalDetailsRepository extends JpaRepository<AdditionalDetails, Integer> {

}
