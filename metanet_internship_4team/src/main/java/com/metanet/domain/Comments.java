package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="COMMENTS")
@Data
public class Comments {
	@Id
	private int Comment_Number;
	private int User_Number;
	private int Video_Number;
	private String Comment_contexts;
	private int CrDa;
	private int DeDa;
}
