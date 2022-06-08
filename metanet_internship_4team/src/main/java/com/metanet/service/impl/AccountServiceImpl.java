
package com.metanet.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Report_Table;
import com.metanet.domain.Users;
import com.metanet.domain.dto.UsersDto;
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
	
	
	public Optional<Users> signUpAccount(UsersDto.SignupRequest signupRequest ) {
			
		Users users = new Users();
		// 데이터 이동 
		users = signupRequest.transferTo(users);
		
		// 날짜생성 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    users.setUserDate(date);
	    	    
	    System.out.println( "12345");
	    System.out.println( users.toString());
	    
		usersRepository.save(users);
		
		return  usersRepository.findByUserId(signupRequest.getUserId());
	}
	
	
	public Optional<Users> getAccount(String userId) {
			
		return  usersRepository.findByUserId(userId);

	}
	
	
	public Optional<Users>  updateAccount (UsersDto.UpdateRequest updateRequest) {
				
		Users findUsers = usersRepository.findByUserId(updateRequest.getUserId()).get();
		
		findUsers= updateRequest.transferTo(findUsers);
		
		// 날짜 넣기 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    findUsers.setUserDate(date);
	    
		usersRepository.save(findUsers);

		return  usersRepository.findByUserId(updateRequest.getUserId());
	
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
	
	
	public Optional<Users> validateForLogin (UsersDto.LoginRequest loginRequest){
				
		return usersRepository.findByUserIdAndUserPassword(loginRequest.getUserId(), loginRequest.getUserPassword() );
	}
	
	
	
	public Optional<Users> validateForFindId (String userName , String userPhoneNumber ,String usersEmail){
		
		System.out.println( userName);
		System.out.println( userPhoneNumber);
		System.out.println( usersEmail);
			
		return usersRepository.findByUserNameAndUserPhoneNumberAndUserEmail(userName, userPhoneNumber,usersEmail );
		
		
	};
	
	
	public Optional<Users> validateForFindPassword( String userName, String usersPhoneNumber ){
		
		return usersRepository.findByUserNameAndUserPhoneNumber(userName, usersPhoneNumber  );
	}
	
	
	public  Optional<Users> updatePassword( String userPhoneNumber , String newPassword) {
		
		Users findUsers = usersRepository.findByUserPhoneNumber(userPhoneNumber).get();
		
		findUsers.setUserPassword(newPassword);
		usersRepository.save(findUsers);
		
		return usersRepository.findByUserPhoneNumber(userPhoneNumber);
	
	};

	
}



