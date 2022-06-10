package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@SequenceGenerator( name = "VIDEO_SEQ_GEN",
					sequenceName = "VIDEO_SEQ",
					initialValue = 1,
					allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIDEO_SEQ_GEN")
	@Column(name = "VIDEO_NUMBER")
	private int videoNumber;
	
//	public int getvideoNumber()
//	{
//		return this.videoNumber;
//	}
//	public void setvideoNumber(int videoNumber)
//	{
//		this.videoNumber=videoNumber;
//	}
	
	@Column(name = "VIDEO_TITLE")
	@NonNull
	private String videoTitle;
	
//	public String getvideoTitle()
//	{
//		return this.videoTitle;
//	}
//	public void setvideoTitle(String videoTitle)
//	{
//		this.videoTitle=videoTitle;
//	}
	
	@Column(name = "VIDEO_CONTEXTS")
	private String videoContexts;
	
//	public String getvideoContexts()
//	{
//		return this.videoContexts;
//	}
//	public void setvideoContexts(String videoContexts)
//	{
//		this.videoContexts=videoContexts;
//	}
	
	@Column(name = "VIDEO_NAME")
	@NonNull
	private String videoName;
	
//	public String getvideoName()
//	{
//		return this.videoName;
//	}
//	public void setvideoName(String videoName)
//	{
//		this.videoName=videoName;
//	}
	
	@Column(name = "RECIPE_LEVEL")
	@NonNull
	private String recipeLevel;
	
//	public String getrecipeLevel()
//	{
//		return this.recipeLevel;
//	}
//	public void setrecipeLevel(String recipeLevel)
//	{
//		this.recipeLevel=recipeLevel;
//	}
	
	@Column(name = "RECIPE_TIME")
	private String recipeTime;
	
//	public String getrecipeTime()
//	{
//		return this.recipeTime;
//	}
//	public void setrecipeTime(String recipeTime)
//	{
//		this.recipeTime=recipeTime;
//	}
	
	@Column(name = "RECIPE_SIZE")
	private String recipeSize;
	
//	public String getrecipeSize()
//	{
//		return this.recipeSize;
//	}
//	public void setrecipeSize(String recipeSize)
//	{
//		this.recipeSize=recipeSize;
//	}
	
	@Column(name = "RECIPE_INGREDIENT")
	private String recipeIngredient;
	
//	public String getrecipeIngredient()
//	{
//		return this.recipeIngredient;
//	}
//	public void setrecipeIngredient(String recipeIngredient)
//	{
//		this.recipeIngredient=recipeIngredient;
//	}
	
	@Column(name = "RECIPE_KIND")
	@NonNull
	private String recipeKind;
	
//	public String getrecipeKind()
//	{
//		return this.recipeKind;
//	}
//	public void setrecipeKind(String recipeKind)
//	{
//		this.recipeKind=recipeKind;
//	}
	
	
//	public java.sql.Time getvideoLength()
//	{
//		return this.videoLength;
//	}
//	public void setvideoLength(java.sql.Time videoLength)
//	{
//		this.videoLength=videoLength;
//	}
	
	@Column(name = "VIDEO_CRDA")
	@NonNull
	private java.sql.Date crDa;
	
//	public java.sql.Date getcrDa()
//	{
//		return this.crDa;
//	}
//	public void setcrDa(java.sql.Date crDa)
//	{
//		this.crDa=crDa;
//	}
	
	@Column(name = "VIDEO_UPDA")
	private java.sql.Date upDa;
	
//	public java.sql.Date getupDa()
//	{
//		return this.upDa;
//	}
//	public void setupDa(java.sql.Date upDa)
//	{
//		this.upDa=upDa;
//	}
	
	@Column(name = "VIDEO_DEDA")
	private java.sql.Date deDa;
	
//	public java.sql.Date getdeDa()
//	{
//		return this.deDa;
//	}
//	public void setdeDa(java.sql.Date deDa)
//	{
//		this.deDa=deDa;
//	}
	
	@Column(name = "VIDEO_VIEW")
	private int videoView;
	
//	public int getvideoView()
//	{
//		return this.videoView;
//	}
//	public void setvideoView(int videoView)
//	{
//		this.videoView=videoView;
//	}
}

