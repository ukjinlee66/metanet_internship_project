package com.metanet.domain;

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
@Table(name="BUY")
@Data
@SequenceGenerator( name = "BUY_SEQ_GEN",
					sequenceName = "BUY_SEQ",
					initialValue = 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Buy 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUY_SEQ_GEN")
	@Column(name = "BUY_NUMBER")
	private int buyNumber;

	@Column(name="USER_NUMBER")
	private int usersNumber;
	
	@Column(name="VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "BUY_DATE")
	private java.sql.Date buyDate;
	
	@Column(name = "BUY_POINT")
	private int buyPoint;
}