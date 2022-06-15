package com.metanet.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metanet.domain.Report;
import com.metanet.domain.Report_Table;
import com.metanet.domain.DTO.ReportBoardRequestDTO;
import com.metanet.repository.ReportRepository;
import com.metanet.repository.Report_TableRepository;
import com.metanet.service.Report_TableService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Report_TableServiceImpl implements Report_TableService{
	
	private final Report_TableRepository reportTableRepository;
	private final ReportRepository reportRepository;
	
	@Transactional
	@Override
	public void saveReport(int userNumber, int reportTableNumber) {
		
		Report report = new Report();	
		
		report.setUsersNumber(userNumber);
		report.setReportTableNumber(reportTableNumber); 
		
		reportRepository.save(report);
		
	}
	
	@Transactional
	@Override
	public int saveAndFindNumber(ReportBoardRequestDTO request) {	
		
		savePost(request);

		Report_Table findreportTable = reportTableRepository.findByReportName(request.getReportName());
		
		return findreportTable.getReportTableNumber();
			
	}
	
	@Transactional
	@Override
	public void savePost(ReportBoardRequestDTO request) {
		
		reportTableRepository.save(request.ToEntity());
		
	}

	@Transactional
	@Override
	public Report_Table getPost(int reportTableNumber) {
		
		Optional<Report_Table> reportTableWrapper = reportTableRepository.findById(reportTableNumber);
		Report_Table reportTable = reportTableWrapper.get();
		
		return reportTable;
	}
	
    @Transactional
	@Override
	public void deletePost(int reportTableNumber) {
		reportTableRepository.deleteById(reportTableNumber);
	}
    
    @Transactional
    @Override
    public List<Report_Table> searchPosts(String keyword){
    	
    	List<Report_Table> data = reportTableRepository.findByreportNameContaining(keyword); 
    	
    	List<Report_Table> boardList = new ArrayList<>();
    	
    	for(Report_Table reportTable : data) {
 			boardList.add(reportTable);
		}
		return boardList;
    }
    
    @Transactional
    @Override
    public List<Report_Table> findMyPosts(int usersNumber){

    	List<Report> myreportdata = reportRepository.findByUsersNumber(usersNumber); 
    	List<Report_Table> reporttablelist = new ArrayList<>();
    	
    	for(Report report :myreportdata) {
    		Report_Table reportTable = reportTableRepository.findByReportTableNumber(report.getReportTableNumber());   
    		reporttablelist.add(reportTable);
    	}
    	return  reporttablelist;
    }

	public void saveAdminReply(String reportReply, Report_Table reportTable) {
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    reportTable.setReDa(date);
	    
		reportTable.setReportReply(reportReply);
		
		reportTableRepository.save(reportTable);
		
	}
}