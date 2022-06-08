package com.metanet.service.DTO;

import java.time.LocalDateTime;

import com.metanet.domain.Report_Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class ReportBoardRequestDTO { //엔티티를 그대로 반환해주면 안되기 때문에 DTO 
	private int reportTableNumber;
	private String reportName;
	private String reportKind;
	private String reportDetail;
	private LocalDateTime crDa;
	
	@Builder
	public ReportBoardRequestDTO(String reportName, String reportKind, String reportDetail) {
		this.reportName = reportName;
		this.reportKind = reportKind;
		this.reportDetail = reportDetail;
		}
	
	public Report_Table ToEntity() {
		return Report_Table.builder()
				.reportName(this.reportName)
				.reportKind(this.reportKind)
				.reportDetail(this.reportDetail)
				.build();
	}
}