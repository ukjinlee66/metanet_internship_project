package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CHARGE")
@Data
public class Charge 
{
	@Id
	private int Charge_Number;
	private int User_Number;
	private String Charge_Date;
	private String Charge_Kind;
	private int Charge_Price;
}
