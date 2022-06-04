package com.metanet.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="REPORT_TABLE")
@Data
@SequenceGenerator( name = "REPORT_TABLE_SEQ_GEN",
					sequenceName = "REPORT_TABLE_SEQ",
					initialValue = - 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Report_Table 
{
	@Id
	@Column(name = "REPORT_TABLENUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_TABLE_SEQ_GEN")
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
