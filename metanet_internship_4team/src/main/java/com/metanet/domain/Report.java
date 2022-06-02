package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="REPORT")
@Data
public class Report 
{
	@Id
	@Column(name = "REPORT_NUMBER")
	private int reportNumber;
	
	@Column(name = "REPORT_USER_NUMBER")
	private int userNumber;
	
	@Column(name = "REPORT_TABLE_NUMBER")
	private int reportTableNumber;
}
