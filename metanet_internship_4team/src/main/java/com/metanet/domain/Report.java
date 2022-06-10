package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="REPORT")
@Data
@SequenceGenerator( name = "REPORT_SEQ_GEN",
					sequenceName = "REPORT_SEQ",
					initialValue = 1,
					allocationSize = 50
					)
@NoArgsConstructor
public class Report 
{
	@Id
	@Column(name = "REPORT_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQ_GEN")
	private int reportNumber;
	
	@Column(name = "USER_NUMBER")
	private int usersNumber;
	
	@Column(name="REPORT_TABLENUMBER")
	private int reportTableNumber;
	
}