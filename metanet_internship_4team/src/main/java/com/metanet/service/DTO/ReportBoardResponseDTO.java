package com.metanet.service.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportBoardResponseDTO {
	private int reportTableNumber;
	private String reportName;
	private String reportKind;
	private String reportDetail; 
	private java.sql.Date crDa;

	
	@Builder
	public ReportBoardResponseDTO(int reportTableNumber, String reportName, String reportKind, String reportDetail) {//수정함 
				this.reportTableNumber = reportTableNumber; //수정함 
				this.reportName = reportName;
				this.reportKind = reportKind;
				this.reportDetail = reportDetail;
	}
}
