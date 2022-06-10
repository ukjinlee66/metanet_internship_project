package com.metanet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Users;
import com.metanet.domain.Video;
import com.metanet.domain.DTO.UsersDTO;
import com.metanet.service.MyPageService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/MyPage")
public class MyPageController {

	@Autowired
	MyPageService myPageService;
	
	

	
	// 시청 기록 영상  c r d
	@GetMapping("/addViews")
	@CrossOrigin
	@ApiOperation(value="회원 시청 영상 저장",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  addViews( @RequestParam("videoName") String videoName,  HttpServletRequest request )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN"))  {
			Users users = (Users)session.getAttribute("info");
			return myPageService.addViews(users.getUserId(), videoName );
		
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}
		
	}
	

	@GetMapping("/getViews/{reckind}")
	@CrossOrigin
	@ApiOperation(value="회원 시청 영상 조회",notes="성공시 List<Video> 반환, 실패시 null 반환 ")
	public List<Video>  getViews(@PathVariable String reckind  ,HttpServletRequest request   )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN"))  {
			Users users = (Users)session.getAttribute("info");
			return myPageService.getViews(users .getUserId(), reckind);
		
		} else {
			System.out.println("You need to login first login first");
			return null;
		}
		
	}
	
	
	@GetMapping("/deleteViews")
	@CrossOrigin
	@ApiOperation(value="회원 시청 영상 삭제",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  deleteViews(@RequestParam("videoName") String videoName,  HttpServletRequest request    )
	{
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			Users users = (Users)session.getAttribute("info");
			return  myPageService.deleteViews(users.getUserId(), videoName);		
			 	
		
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}
			
		 	
	}
	
	
	// 좋아요 영상  c r d
	
	
	
	@GetMapping("/addLikes")
	@CrossOrigin
	@ApiOperation(value="회원 좋아요 영상 저장",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  getLikes(@RequestParam("videoName") String videoName,  HttpServletRequest request   )
	{
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN"))  {
			Users users = (Users)session.getAttribute("info");
			return myPageService.addLikes(users.getUserId(), videoName );
		
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}	
		 	
	}
	

	@GetMapping("/getLikes")
	@CrossOrigin
	@ApiOperation(value="회원 좋아요 영상 조회",notes="성공시 List<Video> 반환, 실패시 null 반환 ")
	public List<Video>  getLikes( HttpServletRequest request  )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			Users users = (Users)session.getAttribute("info");
			return myPageService.getLikes(users.getUserId());
		
		} else {
			System.out.println("You need to login first login first");
			return null;
		}
				 	
	}
	
	
	@GetMapping("/deleteLikes")
	@CrossOrigin
	@ApiOperation(value="회원 좋아요 영상 삭제",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  deleteLikes(@RequestParam("videoName") String videoName,  HttpServletRequest request  )
	{
		
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN"))  {
			Users users = (Users)session.getAttribute("info");
			return  myPageService.deleteLikes(users.getUserId(), videoName);		
			 	
		
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}
		
		
		
	
		 	
	}
	
	
	
	
	// 다시볼 영상  c r  d 
	
	
	@GetMapping("/addSave")
	@CrossOrigin
	@ApiOperation(value="회원 저장 영상 저장",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  addSave(@RequestParam("videoName") String videoName,  HttpServletRequest request  )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN"))  {
			Users users = (Users)session.getAttribute("info");
			return myPageService.addSave(users.getUserId(), videoName );
		
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}	
		 	
	}
	
	
	
	@GetMapping("/getSave")
	@CrossOrigin
	@ApiOperation(value="회원 저장 영상 조회",notes="성공시 List<Video> 반환, 실패시 null 반환 ")
	public List<Video>  getSave( HttpServletRequest request )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN"))  {
			Users users = (Users)session.getAttribute("info");
			return myPageService.getSave(users.getUserId());
		
		} else {
			System.out.println("You need to login first login first");
			return null;
		}
		 	
	}
	
	
	@GetMapping("/deleteSave")
	@CrossOrigin
	@ApiOperation(value="회원 저장 영상 삭제",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  deleteSave( @RequestParam("videoName") String videoName,  HttpServletRequest request  )
	{
		
		
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN"))  {
			Users users = (Users)session.getAttribute("info");
			return  myPageService.deleteSave(users.getUserId(), videoName);		
			 	
		
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}
		
		
		 	
	}
	
	
	
	
	
	
	
	
	
	
	/*
	// 포인트 사용 내역 
	@GetMapping("/getLikes")
	public List<Video>  getLikes(@RequestParam("userId") String userId  )
	{
		return   myPageService.getLikes(userId);		
		 	
	}
	
	// 포인트 충전 
	@GetMapping("/getLikes")
	public List<Video>  getLikes(@RequestParam("userId") String userId  )
	{
		return   myPageService.getLikes(userId);		
		 	
	}
	
	//	문의 내역 
	@GetMapping("/getLikes")
	public List<Video>  getLikes(@RequestParam("userId") String userId  )
	{
		return   myPageService.getLikes(userId);		
		 	
	}
	
	*/
	

	
}
