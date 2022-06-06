package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;

@Entity
@Table(name="COMMENTS")
@Data
@SequenceGenerator( name = "COMMENTS_SEQ_GEN",
					sequenceName = "COMMENTS_SEQ",
					initialValue = - 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Comments 
{
	@Id
	@Column(name="COMMENTS_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQ_GEN")
  @NonNull
	private int commentsNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NUMBER")
	private int usersNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name="COMMENTS_CONTEXTS", columnDefinition = "char")
	private String commentsContexts;
	
	@Column(name="COMMENTS_CRDA")
  @NonNull
	private java.sql.Date crDa;
	
	@Column(name="COMMENTS_DEDA")
	private java.sql.Date deDa;
}
