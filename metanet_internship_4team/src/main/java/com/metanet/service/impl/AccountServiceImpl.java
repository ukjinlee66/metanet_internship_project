
package com.metanet.service.impl;


import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Users;
import com.metanet.dto.UsersDto;
import com.metanet.repository.UsersRepository;
import com.metanet.service.AccountService;



@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	UsersRepository usersRepository;
	
	public int validateId(String userId) {
		
		Optional<Users> findUser = usersRepository.findByUserId(userId);		
		if( findUser.isPresent())  return -1;
		else  return  1; 
		
	}
	
	
	public Optional<Users> signUpAccount(UsersDto usersDto ) {
			
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	
		usersDto.setUserDate(date);		
		Users users = usersDto.toEntity();
		usersRepository.save(users);
		
		return  usersRepository.findByUserId(usersDto.getUserId());
	}
	
	
	public Optional<Users> getAccount(String userId) {
			
		return  usersRepository.findByUserId(userId);

	}
	
	
	public Optional<Users>  updateAccount (UsersDto usersDto) {
				
		Users findUsers = usersRepository.findByUserId(usersDto.getUserId()).get();
		
		// 키 넣기 
		usersDto.setUserNumber(findUsers.getUserNumber());
		
		// 날짜 넣기 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
		usersDto.setUserDate(date);
		Users users = usersDto.toEntity();
		
		usersRepository.save(users);

		return  usersRepository.findByUserId(usersDto.getUserId());
		
	}
	
	public int deleteAccount(String userId) {
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		
		if(findUsers.isPresent()) {
			usersRepository.delete(findUsers.get());
		}
		
		findUsers = usersRepository.findByUserId(userId);
		if(!findUsers.isPresent()) {
			return 1;
		}else {
			return -1;
		}
				
	};
	
	
	public Optional<Users> validateForLogin (UsersDto usersDto){
				
		return usersRepository.findByUserIdAndUserPassword(usersDto.getUserId(),usersDto.getUserPassword() );
	}
	
	
	
	public Optional<Users> validateForFindId (String userName , String userPhoneNumber ,String usersEmail){
		
		System.out.println( userName);
		System.out.println( userPhoneNumber);
		System.out.println( usersEmail);
			
		return usersRepository.findByUserNameAndUserPhoneNumberAndUserEmail(userName, userPhoneNumber,usersEmail );
		
		
	};
	
	
	public Optional<Users> validateForFindPassword( String userId , String userName, String usersEmail ){
		
		return usersRepository.findByUserIdAndUserNameAndUserEmail(userId, userName,usersEmail );
	}
	
	
	public  String updatePassword( String userId, String randomNumber) {
		
		Users findUsers = usersRepository.findByUserId(userId).get();
		
		findUsers.setUserPassword(randomNumber);
		usersRepository.save(findUsers);
		
		return usersRepository.findByUserId(userId).get().getUserPassword();
	};
	
}



