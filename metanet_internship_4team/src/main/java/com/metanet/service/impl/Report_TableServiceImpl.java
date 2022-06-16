/*
package com.metanet.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metanet.domain.Report_Table;
import com.metanet.repository.Report_TableRepository;
import com.metanet.service.Report_TableService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Report_TableServiceImpl implements Report_TableService{
	
	private final Report_TableRepository reportTableRepository;

	

	

	@Transactional
	@Override
	public Report_Table savePost(int userNumber, String reportName, String reportKind, String reportDetail) {

		
		Report_Table report = new Report_Table();
			report.setUserNumber(userNumber);
			report.setReportName(reportName);
			report.setReportKind(reportKind);
			report.setReportDetail(reportDetail);
			
			long millis=System.currentTimeMillis();  
		    java.sql.Date date=new java.sql.Date(millis);  
		    report.setCrDa(date);

		return report;
		
	}



	@Transactional
	@Override
	public ReportBoardRequestDTO getPost(int reportTableNumber) {
		
		Optional<Report_Table> reportTableWrapper = reportTableRepository.findById(reportTableNumber);
		Report_Table reportTable = reportTableWrapper.get();
		
		return ReportBoardRequestDTO.builder()
				.reportName(reportTable.getReportName())
				.reportKind(reportTable.getReportKind())
				.reportDetail(reportTable.getReportDetail())
				.build();
	}

    @Transactional
	@Override
	public void deletePost(int reportTableNumber) {
		reportTableRepository.deleteById(reportTableNumber);
	}
	
//  키워드 검색 
    @Transactional
    @Override
    public List<ReportBoardRequestDTO> searchPosts(String keyword){
    	List<Report_Table> reportTables = reportTableRepository.findByreportNameContaining(keyword); 
    	List<ReportBoardRequestDTO> boardList = new ArrayList<>();
    	
    	for(Report_Table reportTable : reportTables) {
			ReportBoardRequestDTO build = ReportBoardRequestDTO.builder()
					.reportName(reportTable.getReportName())
					.reportKind(reportTable.getReportKind())
					.reportDetail(reportTable.getReportDetail())
					.build();
			
			boardList.add(build);
		}
		return boardList;
    	
    }
    
	public void saveAdminReply(String reportReply, Report_Table reportTable) {
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    reportTable.setReDa(date);
	    
		reportTable.setReportReply(reportReply);
		
		reportTableRepository.save(reportTable);
		
	}

	
	public String findByUserNumber(int userNumber) {
		
		return null;
	}
}
