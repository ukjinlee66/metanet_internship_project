package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(	name = "USER_SEQ_GEN",
					sequenceName = "USERS_SEQ",
					initialValue = 51,
					allocationSize =1
				   )
public class Users {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GEN")
	@Column(name = "USER_NUMBER")
	private int userNumber;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	@Column(name = "USER_PHONE_NUMBER")
	private String userPhoneNumber;
	
	@Column(name = "USER_EMAIL")
	private String userEmail;
	
	@Column(name = "USER_POINT")
	private int userPoint;
	
	@Column(name = "USER_ADDR")
	private String userAddr;
	
	@Column(name = "USER_RECKIND")
	private String userReckind;
	
	@Column(name = "USER_KIND")
	private String userKind;
	
	@Column(name = "USER_DATE")
	private java.sql.Date userDate;
}