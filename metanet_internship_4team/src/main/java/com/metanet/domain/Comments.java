package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="COMMENTS")
@Data
@SequenceGenerator(	name = "Comments_SEQ_GEN",
						sequenceName = "Comments_SEQ",
						initialValue=1,
						allocationSize=1)
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Comments_SEQ_GEN")
	@Column(name = "COMMENTS_NUMBER")
	@NonNull
	private int commentsNumber;
	
	@Column(name = "USER_NUMBER")
	private int usersNumber;
	
	@Column(name = "VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "COMMENTS_CONTEXTS")
	private String commentsContexts;
	
	@Column(name = "COMMENTS_CRDA")
	@NonNull
	private java.sql.Date crDa;
	
	@Column(name = "COMMENTS_DEDA")
	private java.sql.Date deDa;
}
