package com.metanet.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="REPORT_TABLE")
@Data
public class Report_Table 
{
	@Id
	@Column(name = "REPORT_TABLENUMBER")
	private Integer reportTableNumber;
	
	@Column(name = "REPORT_NAME", columnDefinition = "char")
	private String reportName;
	
	@Column(name = "REPORT_KIND", columnDefinition = "char")
	private String reportKind;
	
	@Column(name = "REPORT_DETAIL", columnDefinition = "char")
	private String reportDetail;
	
	@Column(name = "REPORT_REPLY", columnDefinition = "char")
	private String reportReply;
	
	@Column(name = "REPORT_CRDA")
	private LocalDateTime crDa;
	
	@Column(name = "REPORT_REDA")
	private LocalDateTime reDa;
}
