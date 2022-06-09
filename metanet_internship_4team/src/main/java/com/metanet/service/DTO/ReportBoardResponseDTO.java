package com.metanet.service.DTO;

import java.time.LocalDateTime;

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
	private LocalDateTime crDa;

	
	@Builder
	public ReportBoardResponseDTO(String reportName, String reportKind, String reportDetail) {
				this.reportName = reportName;
				this.reportKind = reportKind;
				this.reportDetail = reportDetail;
	}
}
