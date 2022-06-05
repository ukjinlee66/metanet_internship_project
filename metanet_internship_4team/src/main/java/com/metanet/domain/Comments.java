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
	private int commentsNumber;
	@Column(name = "USER_NUMBER")
	private int users_Number;
	@Column(name = "VIDEO_NUMBER")
	private int video_Number;
	@Column(name = "COMMENTS_CONTEXTS")
	private String comments_contexts;
	@Column(name = "COMMENTS_CRDA")
	private java.sql.Date crDa;
	@Column(name = "COMMENTS_DEDA")
	private java.sql.Date deDa;
}
