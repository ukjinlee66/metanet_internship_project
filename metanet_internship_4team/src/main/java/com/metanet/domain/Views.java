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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="VIEWS")
@Data
@SequenceGenerator( name = "VIEWS_SEQ_GEN",
					sequenceName = "VIEWS_SEQ",
					initialValue = - 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Views {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIEWS_SEQ_GEN")
	private Integer View_Number;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NUMBER")
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VIDEO_NUMBER")
	private Video video;
	
	@Column(name="RECENT_TIME")
	private LocalDateTime recentTime;
}
