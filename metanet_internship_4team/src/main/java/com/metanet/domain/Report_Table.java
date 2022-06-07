package com.metanet.domain;

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
	private int Report_TableNumber;
	private String Report_Name;
	private String Report_Info;
	private String Report_CrDa;
	private String Report_ReDa;
}
