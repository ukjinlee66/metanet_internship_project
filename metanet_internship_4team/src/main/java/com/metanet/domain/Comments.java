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
@Table(name="COMMENTS")
@Data
public class Comments {
	@Id
	@Column(name="COMMENTS_NUMBER")
	private Integer commentsNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NUMBER")
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VIDEO_NUMBER")
	private Video video;
	
	@Column(name="COMMENTS_CONTEXTS", columnDefinition = "char")
	private String commentsContexts;
	
	@Column(name="COMMENTS_CRDA")
	private LocalDateTime crDa;
	
	@Column(name="COMMENTS_DEDA")
	private LocalDateTime deDa;
}
