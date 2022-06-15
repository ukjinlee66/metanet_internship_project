package com.metanet.service;

import java.util.List;

import com.metanet.domain.Report_Table;
import com.metanet.domain.DTO.ReportBoardRequestDTO;

public interface Report_TableService {
	
//	public List<ReportBoardRequestDTO> getBoardList();
//	public ReportBoardRequestDTO getPost(int reportTableNumber);
	public Report_Table getPost(int reportTableNumber);
	public void deletePost(int reportTableNumber);
	public List<Report_Table> searchPosts(String keyword);
	
	public void savePost(ReportBoardRequestDTO request);
	
	public int saveAndFindNumber(ReportBoardRequestDTO request);
	
	public void saveReport(int userNumber, int reportTableNumber);
	
	public List<Report_Table> findMyPosts(int usersNumber);
	
	public void saveAdminReply(String reportReply, Report_Table reportTable);
}