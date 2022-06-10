package com.metanet.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metanet.domain.TestOra;



@SpringBootTest
class UsersRepositoryTest {

	@Autowired
	TestOraRepository testOraRepository;
	//UsersRepository userRepository;
	
	@Test
	void test() {
	
		TestOra testOra = new TestOra();
		
		testOra.setUser_id(8);
		testOra.setUser_name("juwooong");
		
		testOraRepository.save(testOra);
		
		/*
		Users signUpDto = new Users();

		String username ="juwoong";
		String userId = "wwong888";
		String userPassword = "1111";
		String phoneNumber ="01045782534";
		int userPoint =0;
		String userAddr = "seoul jongro";
		String recKind = "양식";
		String userKind = "사용자";
		String userDate = "20220508";
		
		
		signUpDto.setUser_Name(username);
		signUpDto.setUser_Id(userId);
		signUpDto.setUser_PassWord(userPassword);
		signUpDto.setUser_Phone_Number(phoneNumber);
		signUpDto.setUser_Point(userPoint);
		signUpDto.setUser_Addr(userAddr);
		signUpDto.setUser_RecKind(recKind);
		signUpDto.setUser_Kind(userKind);
		signUpDto.setUser_Date(userDate);
		
		userRepository.save(signUpDto);
		*/
		
	}
}
