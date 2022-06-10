package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Charge;


@Repository
public interface ChargeRepository extends JpaRepository<Charge, Integer>
{

	public List<Charge> findByUsersNumber (int userNumber); 
	
	
}
