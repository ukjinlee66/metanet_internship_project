package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="CHARGE")
@Data
@SequenceGenerator( name = "CHARGE_SEQ_GEN",
					sequenceName = "CHARGE_SEQ",
					initialValue = 1,
					allocationSize = 1
					)
@NoArgsConstructor
public class Charge 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHARGE_SEQ_GEN")
	@Column(name = "CHARGE_NUMBER")
	private int chargeNumber;
	
	@Column(name="USER_NUMBER")
	private int usersNumber;
	
	@Column(name = "CHARGE_DATE")
	@NonNull
	private java.sql.Date chargeDate;
	
	@Column(name = "CHARGE_PRICE")
	private int chargePrice;
	
	@Column(name = "CHARGE_KIND", columnDefinition = "char")
	@NonNull
	private String chargeKind;
}