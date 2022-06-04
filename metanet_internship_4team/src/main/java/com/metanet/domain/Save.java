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
import lombok.NonNull;

@Entity
@Table(name="SAVE")
@Data
@SequenceGenerator( name = "SAVE_SEQ_GEN",
					sequenceName = "SAVE_SEQ",
					initialValue = - 1,
					allocationSize = 1
					)
@NoArgsConstructor

public class Save {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAVE_SEQ_GEN")
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
