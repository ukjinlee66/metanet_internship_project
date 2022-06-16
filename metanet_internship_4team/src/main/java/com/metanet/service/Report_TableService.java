package com.metanet.service;

import java.util.List;

import com.metanet.domain.Report_Table;

public interface Report_TableService {
	

	public Report_Table getPost(int reportTableNumber);
	
	public void deletePost(int reportTableNumber);
	
	public List<Report_Table> searchPosts(String keyword);
	
	public Report_Table savePost(int userNumber, String reportName, String reportKind, String reportDetail);
	
	public void saveAdminReply(String reportReply, Report_Table reportTable);

	
}