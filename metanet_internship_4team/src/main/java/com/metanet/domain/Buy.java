package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BUY")
@Data
public class Buy 
{
	@Id
	private int Buy_Number;
	private int User_Number;
	private int Video_Number;
	private String Buy_Date;
	private int Buy_Point;
}
