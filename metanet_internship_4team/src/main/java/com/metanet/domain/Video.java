package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="VIDEO")
@Data
@RequiredArgsConstructor
public class Video 
{
	@Id
	@Column(name = "VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "VIDEO_TITLE")
	@NonNull
	private String videoTitle;
	
	@Column(name = "VIDEO_CONTEXTS")
	private String videoContexts;
	
	@Column(name = "VIDEO_URL")
	@NonNull
	private String videoUrl;
	
	@Column(name = "VIDEO_LEVEL")
	private String recipeLevel;
	
	@Column(name = "VIDEO_KIND")
	private String recipeKind;
	
	@Column(name = "VIDEO_LENGTH")
	private int videoLength;
	
	@Column(name = "VIDEO_CRDA")
	@NonNull
	private int crDa;
	
	@Column(name = "VIDEO_UPDA")
	private int upDa;
	
	@Column(name = "VIDEO_DEDA")
	private int deDa;
}

