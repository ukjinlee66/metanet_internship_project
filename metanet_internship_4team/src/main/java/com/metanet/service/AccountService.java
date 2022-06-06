package com.metanet.service;

import java.util.Optional;

import com.metanet.domain.Users;
import com.metanet.dto.UsersDto;

public interface AccountService {


	public int validateId(String userId);
	
	public Optional<Users> signUpAccount(UsersDto usersDto );
	
	public Optional<Users> getAccount(String userId);
	
	public Optional<Users> updateAccount(UsersDto usersDto);
		
	public int deleteAccount(String userId);

	public Optional<Users> validateForLogin (UsersDto usersDto);
	
	
	public Optional<Users> validateForFindId(String userName , String userPhoneNumber ,String usersEmail);
		
	public Optional<Users> validateForFindPassword( String userId , String userName, String usersEmail );
	
	public String updatePassword( String userId, String randomNumber);
	
}
