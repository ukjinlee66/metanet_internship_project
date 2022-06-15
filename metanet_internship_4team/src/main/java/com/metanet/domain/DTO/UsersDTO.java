package com.metanet.domain.DTO;

import com.metanet.domain.Users;

import com.metanet.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UsersDTO 
{

		@NoArgsConstructor
		@AllArgsConstructor
		@Data
		public static class  SignupRequest{
			private String userName;
			private String userId;
			private String userPassword ;
			private String userPhoneNumber;
			private String userEmail;
			private String userAddr;
			private String userReckind;
			
	
			public Users transferTo( Users users ) {
				
				users.setUserName(userName);
				users.setUserId(userId);
				users.setUserPassword(userPassword);
				users.setUserPhoneNumber(userPhoneNumber);
				users.setUserKind('0');
				users.setUserEmail(userEmail);
				users.setUserAddr(userAddr);
				users.setUserRecKind(userReckind);

				return users;
			}
		
		}
	

		@NoArgsConstructor
		@AllArgsConstructor
		@Data
		public static class LoginRequest {
	
			private String userId;
			
			private String userPassword;
			
		}
		
		
		@NoArgsConstructor
		@AllArgsConstructor
		@Data
		public static class InfoResponse {
	
			private String userName;
			private String userId;
			private String userPassword ;
			private int userPoint;
			private String userPhoneNumber;
			private String userEmail;
			private String userAddr;
			private String userReckind;
			private java.sql.Date userDate;
			
			
			public void transferFrom( Users users ) {
				
				userName =users.getUserName();
				userId= users.getUserId();
				userPassword= users.getUserPassword();
				userPoint= users.getUserPoint();
				userPhoneNumber= users.getUserPhoneNumber();
				userEmail= users.getUserEmail();
				userAddr= users.getUserAddr();
				userReckind= users.getUserRecKind();
				userDate = users.getUserDate();
				
			}
			
			
			
		}
		
		

		@NoArgsConstructor
		@AllArgsConstructor
		@Data
		public static class  UpdateRequest{
			private String userName;
			private String userId;
			private String userPassword ;
			private String userPhoneNumber;
			private String userEmail;
			private String userAddr;
			private String userReckind;
			
	
			public Users transferTo( Users users ) {
				
				users.setUserName(userName);
				users.setUserId(userId);
				users.setUserPassword(userPassword);
				users.setUserPhoneNumber(userPhoneNumber);
				users.setUserKind('0');
				users.setUserEmail(userEmail);
				users.setUserAddr(userAddr);
				users.setUserRecKind(userReckind);

				return users;
			}
		
		}
	
		
		
	
		@NoArgsConstructor
		@AllArgsConstructor
		@Data
		public static class FindRequest {
	
			private String userName;
			
			private String userPhoneNumber;
			
			private String userEmail;
			
			
		}
	
	
	
}
