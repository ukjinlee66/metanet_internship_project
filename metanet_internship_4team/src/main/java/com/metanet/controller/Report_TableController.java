package com.metanet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Report_Table;
import com.metanet.domain.Users;
import com.metanet.repository.Report_TableRepository;
import com.metanet.repository.UsersRepository;
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
	private final UsersRepository userrepo;

	@ApiOperation(value="문의글 저장")
	@CrossOrigin
	@PostMapping("/Post")
    public void savePost(@RequestParam int userNumber, String reportName, String reportKind, String reportDetail) {

		Report_Table reportTable = reportTableService.savePost(userNumber, reportName, reportKind, reportDetail);
		reportTableRepository.save(reportTable);
	}
		
	@ApiOperation(value="문의글 답변", notes="성공시 1 반환, 실패시 -1 반환")
	@CrossOrigin
	@PostMapping("/Reply")
    public int saveReply(@RequestParam int reportTableNumber, @RequestParam String reportReply, @RequestParam int userKind) {
		
		Report_Table reportTable = reportTableRepository.findByReportTableNumber(reportTableNumber);

		if(userKind == 1)
		{
			reportTableService.saveAdminReply(reportReply, reportTable);
			
			return 1;
			
		} else
			return -1;
	}

	@ApiOperation(value="나의 문의 내역")
	@CrossOrigin
	@GetMapping("/MyReportList")
	public List<Report_Table> MyPosts(@RequestParam int userNumber) {
		
	    List<Report_Table> findMyPostsList = reportTableRepository.findByUserNumber(userNumber);
		
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
	public List<Report_Table> search(@ApiParam(value="검색어",required=true, example="결제") @RequestParam String reportTitle){

			List<Report_Table> searchList = reportTableService.searchPosts(reportTitle);
			
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
	public Report_Table findPost(@PathVariable("reportTableNumber") int reportTableNumber) {
		
		Report_Table reportTable = reportTableService.getPost(reportTableNumber);
	
//		Users user = userrepo.findByuserNumber(userNumber);
//		String userId = user.getUserId();

		return reportTable;
	}
	
	@ApiOperation(value="사용자 아이디")
	@CrossOrigin
	@GetMapping("/Posts")
	public Users finduserId(@RequestParam int userNumber) {
		
		Users user = userrepo.findByuserNumber(userNumber);

		return user;
	}
	
	@ApiOperation(value="문의글 삭제")
	@CrossOrigin
	@DeleteMapping("/DeletePost/{reportTableNumber}")
	public void delete(@PathVariable("reportTableNumber")int reportTableNumber) {

		reportTableService.deletePost(reportTableNumber);
	
	}
}