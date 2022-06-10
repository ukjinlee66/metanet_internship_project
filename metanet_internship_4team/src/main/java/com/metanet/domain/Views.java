package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="VIEWS")
@Data
@SequenceGenerator(	name = "VIEWS_SEQ_GEN",
					sequenceName = "VIEWS_SEQ",
					initialValue = 1,
					allocationSize =1 )
public class Views {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIEWS_SEQ_GEN")
	@Column(name = "VIEW_NUMBER")
	private int viewNumber;
	
	@Column(name = "USER_NUMBER")
	private int usersNumber;
	
	@Column(name = "VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "RECENT_TIME")
	private java.sql.Date recentTime;
}