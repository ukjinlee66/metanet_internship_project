package com.metanet.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BUY")
@Data
public class Buy 
{
	@Id
	@Column(name = "BUY_NUMBER")
	private Integer buyNumber;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NUMBER")
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VIDEO_NUMBER")
	private Video video;
	
	@Column(name = "BUY_DATE")
	private LocalDateTime buyDate;
	
	@Column(name = "BUY_POINT")
	private int buyPoint;
}
