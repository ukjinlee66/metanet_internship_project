package com.metanet.service;

import java.util.Optional;

import com.metanet.domain.Users;
import com.metanet.domain.DTO.UsersDTO;

public interface AccountService {


	
	public int validateId(String userId);
	
	public Optional<Users> signUpAccount(UsersDTO.SignupRequest signupRequest );
	
	
	public Optional<Users> getAccount(String userId);
	
	public Optional<Users> updateAccount(UsersDTO.UpdateRequest updateRequest);
	
	public int deleteAccount(String userId);
	
	public Optional<Users> validateForLogin (UsersDTO.LoginRequest loginRequest);
	
	public Optional<Users> validateForFindId(String userName , String userPhoneNumber ,String usersEmail);
	
	public Optional<Users> validateForFindPassword( String userName, String usersPhoneNumber );
	
	public int updatePassword( String userId , String newPassword);
	

	
	/*
	public Optional<Users> validateForFindPassword( String userId , String userName, String usersEmail );
	
	

	*/
	
}
