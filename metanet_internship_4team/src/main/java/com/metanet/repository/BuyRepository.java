package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Buy;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Integer>

{

}
