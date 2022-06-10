package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>
{

}
