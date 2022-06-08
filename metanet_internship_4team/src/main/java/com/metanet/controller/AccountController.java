package com.metanet.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Users;
import com.metanet.domain.dto.UsersDto;
import com.metanet.service.AccountService;
import com.metanet.service.impl.MailServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/Account")
public class AccountController {

	
	@Autowired
	private AccountService accountService;
	
	@Autowired	
	private MailServiceImpl mailService;
		
	
	@GetMapping("/validateId")
	@CrossOrigin
	@ApiOperation(value="아이디 중복 확인",notes="회원가입시 아이디 중복여부 확인 / 중복시 -1, 중복 아닐시 1 반환")
	public int  validateId(
			@ApiParam(value="사용자 아이디",required=true) @RequestParam("userId") String userId  
			)
	{
		int result =  accountService.validateId(userId);		
		return result; 	
	}
	
	
	
	@PostMapping("/signUpAccount")
	@CrossOrigin
	@ApiOperation(value="회원가입",notes="회원정보를 통한 화원가입 / 성공시 userNumber 반환, 실패시 -1 반환 / userNumber, userDate 넣지말 것")
	public int signUpAccount( 
			 UsersDto.SignupRequest signupRequest  
			)
	{
			
		Optional<Users> users = accountService.signUpAccount(signupRequest);
		
		if(users.isPresent()) return users.get().getUserNumber();
		else return -1; 	
	}
	
	
	@GetMapping("/getAccount")
	@CrossOrigin
	@ApiOperation(value="회원정보 요청",notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public UsersDto.InfoResponse  getAccount( HttpServletRequest request )
	{
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			
			UsersDto.InfoResponse infoResponse  = new UsersDto.InfoResponse();
			infoResponse.transferFrom((Users)session.getAttribute("info") );
			return infoResponse;
		
		} else {
			System.out.println("You need to login first login first");
			return null;
		}
		
	}
	
	
	
	@PostMapping("/updateAccount")
	@CrossOrigin
	@ApiOperation(value="회원정보 변경",notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 / 유저 넘버와, 날짜만 제외하고 입력할것 ")
	public UsersDto.InfoResponse updateAccount (UsersDto.UpdateRequest updateRequest   , HttpServletRequest request) {
	
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		System.out.println(session.getAttribute("state")); 
		if (session.getAttribute("state").equals("LOG_IN")) {
		
			System.out.println(session.getAttribute("state")); 
			Optional<Users> findUser= accountService.updateAccount(updateRequest);
			if(findUser.isPresent()) {
				
				session.setAttribute("info", findUser.get());
				
				UsersDto.InfoResponse infoResponse = new UsersDto.InfoResponse();
				infoResponse.transferFrom(  (Users)session.getAttribute("info")  );
				return infoResponse;
			}
			else return null;
		} else {
			System.out.println("You need to login first login first");
			return null;
		}	
	}
	
	
	
	@GetMapping("/deleteAccount")
	@CrossOrigin
	@ApiOperation(value="회원정보 삭제",notes="성공시 1, 실패시 -1  반환 ")
	public int  deleteAccount( HttpServletRequest request  )
	{	
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			Users sessionInfo = (Users)session.getAttribute("info");
			String userId = sessionInfo.getUserId();
			return  accountService.deleteAccount(userId);
		
		} else {
			return -1;
		}			
	}
	

	@PostMapping("/login")
	@CrossOrigin
	@ApiOperation(value="로그인",notes="세션을 활용한 로그인 / 성공시 1 반환, 실패시 -1 반환 / userId, userPassword 만 넣을 것")
	public int  login (
			 //UsersDto.LoginRequest loginRequest ,HttpServletRequest request
				@RequestParam String userId, @RequestParam String userPassword, HttpServletRequest request
			) 
	{
		System.out.println(userId);
		
		return 1 ;
		/*
		HttpSession session = request.getSession(true);
	
		Optional<Users> findUser= accountService.validateForLogin(loginRequest);	
		
		if(findUser.isPresent()) {
			session.setAttribute("state", "LOG_IN");
			session.setAttribute("info", findUser.get());
			System.out.println("로그인 성공");
			return 1;
		}else {
			System.out.println("로그인 실패");
			session.setAttribute("state", "NOT_LOG_IN");
			return -1;
		}
		*/
	}
	
	
	
	@GetMapping("/logout")
	@CrossOrigin
	@ApiOperation(value="로그아웃",notes="세션을 활용한 로그아웃 / 완료시 1 반환")
	public int  logout(HttpServletRequest request )
	{
		HttpSession session = request.getSession(true);
		session.invalidate();
		return 1; 	
	}
	
	
	
	@GetMapping("/snsLogin")
	@CrossOrigin
	@ApiOperation(value="SNS 로그인 ",notes="여유가 된다면 추후 진행할 예정")
	public int  snsLogin(UsersDto usersDto )
	{
		return 1; 	
	}	
	
	
	
	
	@PostMapping("/findId")
	@CrossOrigin
	@ApiOperation(value="아이디 찾기" , notes="회원이름, 핸드폰번호, 이메일을 통한 아이디찾기 / 성공시 userID 반환, 실패시 \"no ID\" 반환 / UserName,UserPhoneNumber,UserEmail 만 넣을 것")
	public String  findId(UsersDto.FindRequest findRequest )
	{
		
	
		Optional<Users> finduser =  accountService.validateForFindId(findRequest.getUserName(), findRequest.getUserPhoneNumber() ,findRequest.getUserEmail() );

		if(finduser.isPresent()) return finduser.get().getUserId();	
		else  return "no ID"; 	
	
	}	
	
	
	
	
	@PostMapping("/sendPasswordByEmail")
	@CrossOrigin
	@ApiOperation(value="이메일로 인증번호 보내기" , notes="회원아이디, 회원이름, 이메일을 통한 인증번호 보내기 / 성공시 1 반환, 실패시 -1 반환 / UserName,UserPhoneNumber 만 넣을 것")
	public int  findPassword(UsersDto.FindRequest findRequest , HttpServletRequest request )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		// 입력정보를 통한 검증 
		Optional<Users> findUser =  accountService.validateForFindPassword( findRequest.getUserName(), findRequest.getUserPhoneNumber());
		
		if(findUser.isPresent()) {
			//임시 비밀번호 생성 및 메일 보내기 
			int randomNumber = mailService.sendMail(findUser.get().getUserEmail());
			//세션상태 유지  
			session.setAttribute("state", "FIND_PASSWORD");		
			session.setAttribute("randomNumber", randomNumber);	
			session.setAttribute("userPhoneNumber", findRequest.getUserPhoneNumber());	
			return 1;	
		
		}else  return -1;
		
	 	
	}	
	
	
	@PostMapping("/validateRandomNumber")
	@CrossOrigin
	@ApiOperation(value="인증번호 확인" , notes="인증번호 검증 / 성공시 1 반환, 실패시 -1 반환 ")
	public int  validateRandomNumber (@RequestParam int randomNumber,  HttpServletRequest request )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		

		if (session.getAttribute("state").equals("FIND_PASSWORD")) {
			
			if( (int)session.getAttribute("randomNumber")  ==	randomNumber)  return 1; 	
			else return  -1;
		
		} else {
			return -1;
		}			
		
	}
	
	
	
	@PostMapping("/updatePassword")
	@CrossOrigin
	@ApiOperation(value="비밀번호 업데이트" , notes="회원아이디, 회원이름, 이메일을 통한 아이디찾기 / 성공시 1 반환, 실패시 -1 반환 / UserId, UserPassword 만 넣을 것")
	public int  updatePassword(@RequestParam String newPassword,  HttpServletRequest request)
	{
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("FIND_PASSWORD")) {
			
			Optional<Users> finduser = accountService.updatePassword( (String)session.getAttribute("userPhoneNumber")  , newPassword);
			if(finduser.isPresent()) {
				session.invalidate();
				return 1;
			}else return -1;
		} else {
			return -1;
		}			
	}	

}
