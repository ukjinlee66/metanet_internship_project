package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.domain.Charge;

public interface RefundRepository extends JpaRepository<Charge, Integer> {

}
