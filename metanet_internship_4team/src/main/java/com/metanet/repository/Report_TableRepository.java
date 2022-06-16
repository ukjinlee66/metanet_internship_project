  package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Report_Table;

@Repository
public interface Report_TableRepository extends JpaRepository<Report_Table, Integer>{
	List<Report_Table> findByreportNameContaining(String keyword);
	Report_Table findByReportTableNumber(int reportTableNumber);
	List<Report_Table> findByUserNumber(int userNumber);
}
