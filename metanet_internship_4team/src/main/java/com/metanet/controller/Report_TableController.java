package com.metanet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Report_Table;
import com.metanet.repository.Report_TableRepository;
import com.metanet.service.DTO.ReportBoardRequestDTO;
import com.metanet.service.DTO.ReportBoardResponseDTO;
import com.metanet.service.impl.Report_TableServiceImpl;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Report_TableController {
	private final Report_TableServiceImpl reportTableService;
	private final Report_TableRepository reportTableRepository;
	
	@ApiOperation(value="문의글 저장")
	@PostMapping("/api/post")
    public ReportBoardResponseDTO savePost(@RequestBody ReportBoardRequestDTO request) {

		reportTableService.savePost(request);

        return new ReportBoardResponseDTO(
                request.ToEntity().getReportName(),
                request.ToEntity().getReportKind(),
                request.ToEntity().getReportDetail());
    }
	
//	@ApiOperation(value="문의글 수정")
//	@PutMapping("/api/post/{reportTableNumber}")
//	public ReportBoardResponseDTO updatePost(@PathVariable("reportTableNumber") int reportTableNumber, @RequestBody ReportBoardRequestDTO request) {
//	
//	reportTableService.update(reportTableNumber, request);
//	Optional<Report_Table> findPost = reportTableRepository.findById(reportTableNumber);
//	Report_Table reportTable = findPost.get();
//	
//	return new ReportBoardResponseDTO(
//			reportTable.getReportName(),
//			reportTable.getReportKind(),
//			reportTable.getReportDetail());
//	}

	@ApiOperation(value="문의글 리스트")
	@GetMapping("/api/board/posts")
	public List<ReportBoardRequestDTO> findPosts(){
		List<Report_Table> findAll = reportTableRepository.findAll();
		List<ReportBoardRequestDTO> allPost = new ArrayList<>();
		
		for(Report_Table reportTable : findAll) {
			ReportBoardRequestDTO build = ReportBoardRequestDTO.builder()
					.reportName(reportTable.getReportName())
					.reportKind(reportTable.getReportKind())
					.reportDetail(reportTable.getReportDetail())
					.build();
			
			allPost.add(build);
		}
		return allPost;
	}
	
	@ApiOperation(value="문의 상세 페이지")
	@GetMapping("/api/board/posts/{reportTableNumber}")
	public ReportBoardResponseDTO findPost(@PathVariable("reportTableNumber") int reportTableNumber) {
		ReportBoardRequestDTO post = reportTableService.getPost(reportTableNumber);
		
		return new ReportBoardResponseDTO(
				post.getReportName(),
				post.getReportKind(),
				post.getReportDetail()
				);
				
	}
	
	//게시글 삭제 
	@ApiOperation(value="문의글 삭제")
	@DeleteMapping("/api/post/delete/{reportTableNumber}")
	public void delete(@PathVariable("reportTableNumber")int reportTableNumber) {
		reportTableService.deletePost(reportTableNumber);
	}

}