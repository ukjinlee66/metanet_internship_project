
package com.metanet.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Users;
import com.metanet.domain.DTO.UsersDTO;
import com.metanet.repository.UsersRepository;
import com.metanet.service.AccountService;



@Service
public class AccountServiceImpl implements AccountService 
{
	
	@Autowired
	UsersRepository usersRepository;

	
	
	public int validateId(String userId) {
		
		Optional<Users> findUser = usersRepository.findByUserId(userId);		
		if( findUser.isPresent())  return -1;
		else  return  1; 
		
	}
	
	
	public Optional<Users> signUpAccount(UsersDTO.SignupRequest signupRequest ) {
			
		Users users = new Users();
		// 데이터 이동 
		users = signupRequest.transferTo(users);
		
		// 날짜생성 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    users.setUserDate(date);
	    	    
	 
	    
		usersRepository.save(users);
		
		return  usersRepository.findByUserId(signupRequest.getUserId());
	}
	
	public Users getSingleAccount(Integer userNumber)
	{
		return usersRepository.findByuserNumber(userNumber);
	}
	
	
	public Optional<Users> getAccount(String userId) {
			
		return  usersRepository.findByUserId(userId);

	}
	
	
	public Optional<Users>  updateAccount (UsersDTO.UpdateRequest updateRequest) {
				
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
	
	
	public Optional<Users> validateForLogin (UsersDTO.LoginRequest loginRequest){
				
		return usersRepository.findByUserIdAndUserPassword(loginRequest.getUserId(), loginRequest.getUserPassword() );
	}
	
	
	
	public Optional<Users> validateForFindId (String userName , String userPhoneNumber ,String usersEmail){
		
		System.out.println( userName);
		System.out.println( userPhoneNumber);
		System.out.println( usersEmail);
			
		return usersRepository.findByUserNameAndUserPhoneNumberAndUserEmail(userName, userPhoneNumber,usersEmail );
		
		
	};
	
	
	
	
	public Optional<Users> validateForFindPassword( String userName, String usersEmail ){
		
		return usersRepository.findByUserNameAndUserEmail(userName, usersEmail  );
	}
	
	
	public int updatePassword( String userId,  String newPassword) {
		
		Optional<Users> findUser = usersRepository.findByUserId(userId);
		
		if(findUser.isPresent()) {
			findUser.get().setUserPassword(newPassword);
			usersRepository.save(findUser.get());	
			return 1; 
	
		}else return -1;

	};

	
}



