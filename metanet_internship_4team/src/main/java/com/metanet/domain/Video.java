package com.metanet.domain;

import java.time.LocalDateTime;

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
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="VIDEO")
@Data
@RequiredArgsConstructor
@SequenceGenerator( name = "VIDEO_SEQ_GEN",
					sequenceName = "VIDEO_SEQ",
					initialValue = - 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Video 
{
	@Id
	@Column(name = "VIDEO_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIDEO_SEQ_GEN")
	private Integer videoNumber;
	
	@Column(name = "VIDEO_TITLE", columnDefinition = "char")
	@NonNull
	private String videoTitle;
	
	@Column(name = "VIDEO_CONTEXTS", columnDefinition = "char")
	private String videoContexts;
	
	@Column(name = "VIDEO_URL", columnDefinition = "char")
	@NonNull
	private String videoUrl;
	
	@Column(name = "RECIPE_LEVEL", columnDefinition = "char")
	private String recipeLevel;
	
	@Column(name = "RECIPE_KIND", columnDefinition = "char")
	private String recipeKind;
	
	@Column(name = "VIDEO_LENGTH")
	private LocalDateTime videoLength;
	
	@Column(name = "VIDEO_CRDA")
	@NonNull
	private LocalDateTime crDa;
	
	@Column(name = "VIDEO_UPDA")
	private LocalDateTime upDa;
	
	@Column(name = "VIDEO_DEDA")
	private LocalDateTime deDa;

}

