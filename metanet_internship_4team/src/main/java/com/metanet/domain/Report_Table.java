package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="REPORT_TABLE")
@Data
@SequenceGenerator( name = "REPORT_TABLE_SEQ_GEN",
					sequenceName = "REPORT_TABLE_SEQ",
					initialValue =  1,
					allocationSize = 50
					)
@AllArgsConstructor
@NoArgsConstructor
public class Report_Table 
{
	@Id
	@Column(name = "REPORT_TABLENUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_TABLE_SEQ_GEN")
	private int reportTableNumber;
	
	@Column(name = "REPORT_NAME", columnDefinition = "char")
	@NonNull
	private String reportName;
	
	@Column(name = "REPORT_KIND", columnDefinition = "char")
	private String reportKind;
	
	@Column(name = "REPORT_DETAIL", columnDefinition = "char")
	private String reportDetail;
	
	@Column(name = "REPORT_REPLY", columnDefinition = "char")
	private String reportReply;
	
	@CreationTimestamp
	@Column(name = "REPORT_CRDA")
	@NonNull
	private java.sql.Date crDa;
	
	@CreationTimestamp
	@Column(name = "REPORT_REDA")
	private java.sql.Date reDa;

	@Builder
	public Report_Table(int reportTableNumber, String reportName, String reportKind, String reportDetail) {
		this.reportTableNumber = reportTableNumber;
		this.reportName = reportName;
		this.reportKind = reportKind;
		this.reportDetail = reportDetail;
	}
}
