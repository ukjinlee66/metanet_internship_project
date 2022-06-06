package com.metanet.dto;

import javax.persistence.Column;

import com.metanet.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDto {

	private int userNumber;
	
	private String userName;
	
	private String userId;
	
	private String userPassword;
	
	private String userPhoneNumber;
	
	private String userEmail;
	
	private int userPoint;
	
	private String userAddr;
	
	private String userReckind;
	
	private String userKind;
	
	private java.sql.Date userDate;
	
	
	
	public UsersDto (Users users) {
		
		this.userNumber= users.getUserNumber();
				
				
		this.userName= users.getUserName();
		
		this.userId= users.getUserId();
		
		this.userPassword= users.getUserPassword();
		
		this.userPhoneNumber= users.getUserPhoneNumber();
		
		this.userEmail = users.getUserEmail();
		
		this.userPoint= users.getUserPoint();
		
		this.userAddr = users.getUserAddr();
		
		this.userReckind = users.getUserReckind();
		
		this.userKind= users.getUserKind();
		
		this.userDate= users.getUserDate();
		
		

	}

	public Users toEntity() {
		
		 Users users = new Users(userNumber,userName , userId ,userPassword, userPhoneNumber, userEmail, userPoint, userAddr, userReckind, userKind,  userDate
					);
		return users;
	}
	
	
	
	
	
}
