package com.metanet.domain;

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
	@Column(name = "REPORT_TABLE_NUMBER")
	private int reportTableNumber;
	
	@Column(name = "REPORT_TABLE_NAME")
	private String reportName;
	
	@Column(name = "REPORT_TABLE_INFO")
	private String reportInfo;
	
	@Column(name = "REPORT_TABLE_CRDA")
	private java.sql.Date crDa;
	
	@Column(name = "REPORT_TABLE_REDA")
	private java.sql.Date reDa;
}
