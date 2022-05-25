package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="LIKES")
@Data
public class Likes {
	@Id
	private int Likes_Number;
	private int Users_Number;
	private int Video_Number;
	private int Likes_CrDa;
	private int Likes_Upda;
	private int Likes_DeDa;	
}
