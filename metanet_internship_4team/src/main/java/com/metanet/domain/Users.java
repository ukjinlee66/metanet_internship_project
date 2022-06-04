package com.metanet.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USERS")
@Data
public class Users {
	@Id
	private Integer User_Number;
	
	@Column(name = "USER_NAME", columnDefinition = "char")
	private String userName;

	@Column(name = "USER_ID", columnDefinition = "char")
	private String userId;
	
	@Column(name = "USER_PASSWORD", columnDefinition = "char")
	private String userPassWord;
	
	@Column(name = "USER_PHONE_NUMBER", columnDefinition = "char")
	private String userPhoneNumber;
	
	@Column(name = "USER_POINT")
	private int userPoint;
	
	@Column(name = "USER_ADDR", columnDefinition = "char")
	private String userAddr;
	
	@Column(name = "USER_RECKIND", columnDefinition = "char")
	private String userRecKind;

	@Column(name = "USER_KIND", columnDefinition = "char")
	private String userKind;

	@Column(name = "USER_DATE")
	private LocalDateTime userDate;
}