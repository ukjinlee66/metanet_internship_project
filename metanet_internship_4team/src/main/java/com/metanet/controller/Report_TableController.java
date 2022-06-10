package com.metanet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Report_Table;
import com.metanet.repository.Report_TableRepository;
import com.metanet.service.DTO.ReportBoardRequestDTO;
import com.metanet.service.DTO.ReportBoardResponseDTO;
import com.metanet.service.impl.Report_TableServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Report")
public class Report_TableController {
	private final Report_TableServiceImpl reportTableService;
	private final Report_TableRepository reportTableRepository;
	
	@ApiOperation(value="문의글 저장")
	@CrossOrigin
	@PostMapping("/Post")
    public ReportBoardResponseDTO savePost(@RequestBody ReportBoardRequestDTO request) {

		reportTableService.savePost(request);

        return new ReportBoardResponseDTO(
        		request.getReportTableNumber(), //수
                request.getReportName(),
                request.getReportKind(),
                request.getReportDetail());
    }
	
	@ApiOperation(value="문의글 리스트")
	@CrossOrigin
	@GetMapping("/List")
	public List<Report_Table> findPosts(){
		List<Report_Table> findAll = reportTableRepository.findAll(); //마이페이지 문의글 리스트 findbyusernumber
//		List<ReportBoardRequestDTO> allPost = new ArrayList<>();
//		
//		for(Report_Table reportTable : findAll) {
//			ReportBoardRequestDTO build = ReportBoardRequestDTO.builder()
//					.reportName(reportTable.getReportName())
//					.reportKind(reportTable.getReportKind())
//					.reportDetail(reportTable.getReportDetail())
//					.build();
//			
//			allPost.add(build);
//		}
		return findAll;
	}
	
	@GetMapping("/Posts/SearchPost")
	@CrossOrigin
	@ApiOperation(value="문의글 검색")
	public List<ReportBoardRequestDTO> search(
		@ApiParam(value="검색어",required=true, example="결제") @RequestParam String reportTitle)	{
			System.out.println("IN: "+reportTitle);
			List<ReportBoardRequestDTO> searchList = reportTableService.searchPosts(reportTitle);
			if(reportTitle == null) {
				searchList = reportTableService.searchPosts(null);
	        }else {
	        	searchList = reportTableService.searchPosts(reportTitle);
	        }
			return searchList;
			}
	
	@ApiOperation(value="문의 상세 페이지")
	@CrossOrigin
	@GetMapping("/Posts/{reportTableNumber}")
	public ReportBoardResponseDTO findPost(@PathVariable("reportTableNumber") int reportTableNumber) {
		ReportBoardRequestDTO post = reportTableService.getPost(reportTableNumber);
		
		return new ReportBoardResponseDTO(
				post.getReportTableNumber(), //수정
				post.getReportName(),
				post.getReportKind(),
				post.getReportDetail()
				);
				
	}

	@ApiOperation(value="문의글 삭제")
	@CrossOrigin
	@DeleteMapping("/DeletePost/{reportTableNumber}")
	public void delete(@PathVariable("reportTableNumber")int reportTableNumber) {
		reportTableService.deletePost(reportTableNumber);
	}
}