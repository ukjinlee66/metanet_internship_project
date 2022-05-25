package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="VIDEO")
@Data
public class Video {
	@Id
	private int Video_Number; 
	private String Video_Title; 
	private String Video_Contexts;
	private String Video_Url;
	private String Recipe_Level; 
	private String Recipe_Kind; 
	private int Video_Length;
	private int CrDa;
	private int UpDa;
	private int DeDa;
}

