package com.metanet.service;

import java.util.List;

import com.metanet.service.DTO.ReportBoardRequestDTO;

public interface Report_TableService {
	public void savePost(ReportBoardRequestDTO boardDto);
	public List<ReportBoardRequestDTO> getBoardList();
	public ReportBoardRequestDTO getPost(int reportTableNumber);
	public void deletePost(int reportTableNumber);
	public List<ReportBoardRequestDTO> searchPosts(String keyword);
//	public void update(int reportTableNumber, ReportBoardRequestDTO dto);
}