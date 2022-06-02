package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="CHARGE")
@Data
public class Charge 
{
	@Id
	@Column(name = "CHARGE_NUMBER")
	private int chargeNumber;
	
	@Column(name = "CHARGE_USER_NUMBER")
	private int userNumber;
	
	@Column(name = "CHARGE_DATE")
	@NonNull
	private java.sql.Date chargeDate;
	
	@Column(name = "CHARGE_PRICE")
	private int chargePrice;
	
	@Column(name = "CHARGE_KIND")
	@NonNull
	private String chargeKind;
}
