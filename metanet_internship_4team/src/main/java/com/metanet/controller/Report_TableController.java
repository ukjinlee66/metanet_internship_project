package com.metanet.controller;

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

import com.metanet.domain.Report;
import com.metanet.domain.Report_Table;
import com.metanet.domain.DTO.ReportBoardRequestDTO;
import com.metanet.domain.DTO.ReportBoardResponseDTO;
import com.metanet.repository.Report_TableRepository;
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


	@ApiOperation(value="문의글 저장",notes="성공시 1 반환, 실패시 -1 반환")
	@CrossOrigin
	@PostMapping("/Post")
    public ReportBoardResponseDTO savePost(@RequestBody ReportBoardRequestDTO request, int userNumber) {
		
//		if(userId.equals("none"))return -1;
		int reportTableNumber = reportTableService.saveAndFindNumber(request);
		
		reportTableService.saveReport(userNumber, reportTableNumber);
        
		return new ReportBoardResponseDTO(
        		request.getReportTableNumber(),
                request.getReportName(),
                request.getReportKind(),
                request.getReportDetail());
    }
	
	@ApiOperation(value="마이페이지 문의글 리스트")
	@CrossOrigin
	@GetMapping("/MyList")
	public List<Report_Table> MyPosts(@RequestParam int userNumber) {
		// findbyuserNumber로 report값 저장.
		// findbyReportTableNumber로 reportTable 저장.
		
	    List<Report_Table> findMyPostsList = reportTableService.findMyPosts(userNumber);
		
		//List<Report_Table> findMyPostsList = reportTableService.findMyPosts(userNumber);

		return findMyPostsList;
	}
	
	@ApiOperation(value="문의글 리스트")
	@CrossOrigin
	@GetMapping("/List")
	public List<Report_Table> findPosts(){
		List<Report_Table> findAll = reportTableRepository.findAll();
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
				post.getReportTableNumber(),
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