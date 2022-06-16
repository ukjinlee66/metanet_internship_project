package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>
{

//	public void save(ReportDTO reportDTO);
	
//	List<Report_Table> findByReportTableNumber(int reportTableNumber);
	
	List<Report> findByUsersNumber(int UserNumber);
}
