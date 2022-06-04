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
@Table(name="VIDEO")
@Data
@SequenceGenerator( name = "VIDEO_SEQ_GEN",
					sequenceName = "VIDEO_SEQ",
					initialValue = 1,
					allocationSize = 1)
@NoArgsConstructor
public class Video 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIDEO_SEQ_GEN")
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
	
	@Column(name = "RECIPE_LEVEL")
	private String recipeLevel;
	
	@Column(name = "RECIPE_KIND")
	private String recipeKind;
	
	@Column(name = "VIDEO_LENGTH")
	private java.sql.Time videoLength;
	
	@Column(name = "VIDEO_CRDA")
	@NonNull
	private java.sql.Date crDa;
	
	@Column(name = "VIDEO_UPDA")
	private java.sql.Date upDa;
	
	@Column(name = "VIDEO_DEDA")
	private java.sql.Date deDa;
	
	@Column(name = "VIDEO_VIEW")
	private int videoView;
}

