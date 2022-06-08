package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Table(name="VIDEO")
@Data
@NoArgsConstructor

@SequenceGenerator(	name = "VIDEO_SEQ_GEN",
sequenceName = "VIDEO_SEQ",
initialValue = 1,
allocationSize =50
)

public class Video 
{
	@Id
	@Column(name = "VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "VIDEO_TITLE")
	private String videoTitle;
	
	@Column(name = "VIDEO_NAME")
	private String videoName;
	
	@Lob
	@Column(name = "VIDEO_CONTEXTS")
	private String videoContexts;
	
	@Column(name = "RECIPE_LEVEL")
	private String recipeLevel;
	
	@Column(name = "RECIPE_KIND")
	private String recipeKind;
	
	@Column(name = "RECIPE_TIME")
	private int recipeTime;
	
	@Column(name = "RECIPE_SIZE")
	private int recipeSize;
	
	@Column(name = "RECIPE_INGREDIENT")
	private String recipeIngredient;
	
	@Column(name = "VIDEO_VIEW")
	private int videoView;
	
	@Column(name = "VIDEO_CRDA")
	@NonNull
	private java.sql.Date crDa;
	
	@Column(name = "VIDEO_UPDA")
	private java.sql.Date upDa;
	
	@Column(name = "VIDEO_DEDA")
	private java.sql.Date deDa;
	
}

