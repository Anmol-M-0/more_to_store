package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.TechnicalDetails;
@Repository
public interface TechnicalDetailsRepository extends JpaRepository<TechnicalDetails, Integer> {

}
