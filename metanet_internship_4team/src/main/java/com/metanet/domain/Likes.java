package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="LIKES")
@Data
public class Likes {
	@Id
	@Column(name="LKIES_USER")
	private int likesNumber;
	
	@Column(name="LIKES_USER_NUMBER")
	private int userNumber;

	@Column(name="LIKES_VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name="LIKES_CRDA")
	private java.sql.Date crDa;
	
	@Column(name="LIKES_UPDA")
	private java.sql.Date upDa;
	
	@Column(name="LIKES_DEDA")
	private java.sql.Date deDa;	
}
