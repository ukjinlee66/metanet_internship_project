package com.metanet.domain;

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
	private int Report_Number;
	private int User_Number;
	private int Report_TableNumber;
}
