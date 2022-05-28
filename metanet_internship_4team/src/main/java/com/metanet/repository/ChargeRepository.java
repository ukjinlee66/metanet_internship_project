package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Charge;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Integer> {

}
