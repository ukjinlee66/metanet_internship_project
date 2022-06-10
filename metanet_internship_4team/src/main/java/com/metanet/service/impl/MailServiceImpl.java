package com.metanet.service.impl;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.metanet.service.MailService;

@Service
public class MailServiceImpl implements  MailService{

	@Autowired
	private JavaMailSender javaMailSender;


	public int sendMail(String UserEmail) {
		
		
		ArrayList<String> toUserList = new ArrayList<>();
		
		toUserList.add(UserEmail);
		
		
		int toUserSize = toUserList.size();
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		
		// 수신자 제목 
		simpleMessage.setTo( (String[]) toUserList.toArray(new String[ toUserSize]));
		
		// 메일 제목 
		simpleMessage.setSubject("임시 비밀번호 발급");
		
		// 메일 내용 
		Random random = new Random();
		int randomNumber =random.nextInt(1000000)+99999;
		String message = "발급된 인증번호는 "+  Integer.toString(randomNumber) + "입니다. 페이지에 입력해주세요";
		simpleMessage.setText(message);
		
		// 메일 발송 
		javaMailSender.send(simpleMessage);
	
		return randomNumber;
	}
	
	
	

}
