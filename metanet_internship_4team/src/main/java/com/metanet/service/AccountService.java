package com.metanet.service;

import java.util.Optional;

import com.metanet.domain.Report_Table;
import com.metanet.domain.Users;
import com.metanet.domain.dto.UsersDto;

public interface AccountService {


	
	public int validateId(String userId);
	
	public Optional<Users> signUpAccount(UsersDto.SignupRequest signupRequest );
	
	
	public Optional<Users> getAccount(String userId);
	
	public Optional<Users> updateAccount(UsersDto.UpdateRequest updateRequest);
	
	public int deleteAccount(String userId);
	
	public Optional<Users> validateForLogin (UsersDto.LoginRequest loginRequest);
	
	public Optional<Users> validateForFindId(String userName , String userPhoneNumber ,String usersEmail);
	
	public Optional<Users> validateForFindPassword( String userName, String usersPhoneNumber );
	
	public Optional<Users> updatePassword( String userPhoneNumber , String newPassword);
	
	/*
	public Optional<Users> validateForFindPassword( String userId , String userName, String usersEmail );
	
	

	*/
	
}
