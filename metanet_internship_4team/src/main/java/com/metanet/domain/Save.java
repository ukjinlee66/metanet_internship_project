package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SAVE")
@Data
public class Save {
	@Id
	private int Save_Number;
	private int User_Number;
	private int Video_Number;
	private int Save_CrDa;
	private int Save_DeDa;
}
