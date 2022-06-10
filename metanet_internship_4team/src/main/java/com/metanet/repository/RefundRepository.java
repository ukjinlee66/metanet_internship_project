package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.domain.Refund;

public interface RefundRepository extends JpaRepository< Refund, Integer>
{

	public List<Refund> findByUsersNumber (int userNumber);
	
}

