package com.metanet.service.DTO;

import com.metanet.domain.Report_Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportBoardRequestDTO { //엔티티를 그대로 반환해주면 안되기 때문에 DTO 
	private int reportTableNumber;
	private String reportName;
	private String reportKind;
	private String reportDetail;
	private java.sql.Date crDa;
	
	@Builder
	public ReportBoardRequestDTO(int reportTableNumber, String reportName, String reportKind, String reportDetail) {
		this.reportTableNumber = reportTableNumber;
		this.reportName = reportName;
		this.reportKind = reportKind;
		this.reportDetail = reportDetail;
		}
	
	public Report_Table ToEntity() {
		return Report_Table.builder()
				.reportTableNumber(this.reportTableNumber)//tnwjd
				.reportName(this.reportName)
				.reportKind(this.reportKind)
				.reportDetail(this.reportDetail)
				.build();
	}
}