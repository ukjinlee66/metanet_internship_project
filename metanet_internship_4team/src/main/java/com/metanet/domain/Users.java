package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USERS")
@Data
public class Users {
	@Id
	private int User_Number;
	private String User_Name;
	private String User_Id;
	private String User_PassWord;
	private int User_Phone_Number;
	private int User_Point;
	private String User_Addr;
	private String User_RecKind;
	private String User_Kind;
	private String User_Date;
}