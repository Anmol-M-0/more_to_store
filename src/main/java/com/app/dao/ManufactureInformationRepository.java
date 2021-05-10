package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.ManufactureInformation;

@Repository
public interface ManufactureInformationRepository extends JpaRepository<ManufactureInformation, Integer> {

}
