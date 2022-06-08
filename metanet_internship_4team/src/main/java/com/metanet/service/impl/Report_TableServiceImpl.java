package com.metanet.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metanet.domain.Report_Table;
import com.metanet.repository.Report_TableRepository;
import com.metanet.service.Report_TableService;
import com.metanet.service.DTO.ReportBoardRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Report_TableServiceImpl implements Report_TableService{
	
	private final Report_TableRepository reportTableRepository;
	
	@Transactional
	@Override
	public void savePost(ReportBoardRequestDTO boardDto) {
		reportTableRepository.save(boardDto.ToEntity());
	}

	@Transactional
	@Override
	public List<ReportBoardRequestDTO> getBoardList(){
		
		List<Report_Table> all = reportTableRepository.findAll();
		List<ReportBoardRequestDTO> boardDtoList = new ArrayList<>();
		
		for(Report_Table reportTable : all) {
			ReportBoardRequestDTO boardDto = ReportBoardRequestDTO.builder()
					.reportName(reportTable.getReportName())
					.reportKind(reportTable.getReportKind())
					.reportDetail(reportTable.getReportDetail())
					.build();
			
			boardDtoList.add(boardDto);
		}
		return boardDtoList;
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
	
	// 키워드 검색 
//    @Transactional
//    @Override
//    public List<ReportBoardRequestDTO> searchPosts(String keyword){
//    	List<Report_Table> reportTable = reportTableRepository.findByTitleContaining(keyword); 
//    	List<ReportBoardRequestDTO> boardList = new ArrayList<>();
//    	
//    	for(Report_Table reportTable : reportTables) {
//			ReportBoardRequestDTO build = ReportBoardRequestDTO.builder()
//					.reportName(reportTable.getReportName())
//					.reportKind(reportTable.getReportKind())
//					.reportDetail(reportTable.getReportDetail())
//					.build();
//			
//			boardList.add(build);
//		}
//		return boardList;
//    	
//    }
//
    // 게시글 수정 
//    @Transactional
//    @Override
//    public void update(int reportTableNumber, ReportBoardRequestDTO dto) {
//        Optional<Report_Table> byId = reportTableRepository.findById(reportTableNumber);
//        Report_Table reportTable = byId.get();
//
//        reportTable.updateBoard(dto.getReportName(), dto.getReportKind(), dto.getReportDetail());
//    }

}