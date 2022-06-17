package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;


@Entity
@Table(name="VIDEO")
@AllArgsConstructor
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIDEO_SEQ_GEN")
	private int videoNumber;

	@Column(name = "VIDEO_TITLE")
	@NonNull
	private String videoTitle;
	
	@Column(name = "VIDEO_NAME")
	@NonNull
	private String videoName;

	@Lob
	@Column(name = "VIDEO_CONTEXTS")
	private String videoContexts;
	
	@Column(name = "RECIPE_LEVEL")
	@NonNull
	private String recipeLevel;
	
	@Column(name = "RECIPE_KIND")
	@NonNull
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

