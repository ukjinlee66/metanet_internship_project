package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BUY")
@Data
public class Buy 
{
	@Id
	@Column(name = "BUY_NUMBER")
	private int buyNumber;
	
	@Column(name = "BUY_USER_NUMBER")
	private int userNumber;
	
	@Column(name = "BUY_VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "BUY_DATE")
	private java.sql.Date buyDate;
	
	@Column(name = "BUY_POINT")
	private int buyPoint;
}
