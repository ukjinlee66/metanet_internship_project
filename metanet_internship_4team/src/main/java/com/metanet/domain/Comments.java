package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="COMMENTS")
@Data
public class Comments {
	@Id
	@Column(name="COMMENTS_NUBMER")
	private int commentsNumber;
	
	@Column(name="COMMENTS_USER_NUMBER")
	private int userNumber;
	
	@Column(name="COMMENTS_VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name="COMMENTS_COMMENTS_CONTEXTS")
	private String commentsContexts;
	
	@Column(name="COMMENTS_CRDA")
	private java.sql.Date crDa;
	
	@Column(name="COMMENTS_DEDA")
	private java.sql.Date deDa;
}
