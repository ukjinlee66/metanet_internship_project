package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="REPORT")
@Data
@SequenceGenerator( name = "REPORT_SEQ_GEN",
					sequenceName = "REPORT_SEQ",
					initialValue = - 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Report 
{
	@Id
	@Column(name = "REPORT_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQ_GEN")
	private Integer reportNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NUMBER")
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REPORT_TABLENUMBER")
	private Report_Table report_Table;
}
