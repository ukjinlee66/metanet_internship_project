package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Report_Table;

@Repository
public interface Report_TableRepository extends JpaRepository<Report_Table, Integer>

{

}
