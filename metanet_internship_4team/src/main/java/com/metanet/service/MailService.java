package com.metanet.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

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
		int randomNumber =random.nextInt();
		String message = "임시발급된 비밀본호는 "+  Integer.toString(randomNumber) + "입니다. 로그인 한 뒤 변경해주세요";
		simpleMessage.setText(message);
		
		// 메일 발송 
		javaMailSender.send(simpleMessage);
	
		return randomNumber;
	}
	
	
	

}
