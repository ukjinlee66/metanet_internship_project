package com.metanet.domain.DTO;

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
	public ReportBoardResponseDTO(int reportTableNumber, String reportName, String reportKind, String reportDetail) {
				this.reportTableNumber = reportTableNumber;
				this.reportName = reportName;
				this.reportKind = reportKind;
				this.reportDetail = reportDetail;
	}
}
