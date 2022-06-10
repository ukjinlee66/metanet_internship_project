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
import lombok.NonNull;

@Entity
@Table(name="COMMENTS")
@Data
@SequenceGenerator( name = "COMMENTS_SEQ_GEN",
					sequenceName = "COMMENTS_SEQ",
					initialValue = 1,
					allocationSize = 50
					)
@NoArgsConstructor
public class Comments 
{
	@Id
	@Column(name="COMMENTS_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQ_GEN")
	private int commentsNumber;
	
	@Column(name="USER_NUMBER")
	private int  userNumber;
	
	@Column(name="VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "COMMENTS_CONTEXTS")
	private String commentsContexts;
	
	@Column(name="COMMENTS_CRDA")
	@NonNull
	private java.sql.Date crDa;
	
	@Column(name="COMMENTS_DEDA")
	private java.sql.Date deDa;
}
