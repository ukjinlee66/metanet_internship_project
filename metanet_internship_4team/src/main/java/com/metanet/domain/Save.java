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
import lombok.NonNull;

@Entity
@Table(name="SAVE")
@Data
public class Save {
	@Id
	private Integer Save_Number;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NUMBER")
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VIDEO_NUMBER")
	private Video video;
	
	@Column(name="SAVE_CRDA")
	@NonNull
	private LocalDateTime Save_CrDa;
	
	@Column(name="SAVE_DEDA")
	private LocalDateTime Save_DeDa;
}
