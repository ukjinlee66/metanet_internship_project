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

@Entity
@Table(name="REFUND")
@Data
@SequenceGenerator( name = "REFUND_SEQ_GEN",
					sequenceName = "REFUND_SEQ",
					initialValue = 1,
					allocationSize = 50
					)
@NoArgsConstructor
public class Refund {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REFUND_SEQ_GEN")
	@Column(name = "REFUND_NUMBER")
	private int refundNumber;
	
	@Column(name = "USER_NUMBER")
	private int usersNumber;
	
	@Column(name = "REFUND_POINT")
	private int refundPoint;
	
	@Column(name = "REFUND_DATE")
	private java.sql.Date  refundDate;
	
		
	
}
