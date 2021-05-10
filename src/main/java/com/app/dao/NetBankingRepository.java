package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.NetBanking;
@Repository
public interface NetBankingRepository extends JpaRepository<NetBanking, Long>{

}
