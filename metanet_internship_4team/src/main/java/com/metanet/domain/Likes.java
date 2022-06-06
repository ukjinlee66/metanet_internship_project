package com.metanet.domain;

import java.time.LocalDateTime;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="LIKES")
@Data
@SequenceGenerator( name = "LIKES_SEQ_GEN",
					sequenceName = "LIKES_SEQ",
					initialValue = - 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Likes {
	
	@Id
	@Column(name="LIKES_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIKES_SEQ_GEN")
	private Integer likesNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NUMBER")
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VIDEO_NUMBER")
	private Video video;
	
	@Column(name="LIKES_CRDA")
	@NonNull
	private LocalDateTime crDa;
	
	@Column(name="LIKES_UPDA")
	private LocalDateTime upDa;
	
	@Column(name="LIKES_DEDA")
	private LocalDateTime deDa;	
}