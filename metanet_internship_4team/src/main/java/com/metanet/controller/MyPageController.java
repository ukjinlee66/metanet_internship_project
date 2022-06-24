package com.metanet.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.metanet.domain.DTO.VideoDTO;
import com.metanet.service.MyPageService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/MyPage")
public class MyPageController {

	@Autowired
	MyPageService myPageService;
	
	@Autowired
	VideoDTO videoDTO;
	
	
	
	public List<VideoDTO.detailResponse> changeResult(List<Video> v)throws  IOException{
		
		List<VideoDTO.detailResponse> vList = new ArrayList<>();

		for(int i =0 ; i< v.size(); i++) {
			VideoDTO.detailResponse temp = videoDTO.new detailResponse();
			temp.transferFrom(v.get(i));	
			vList.add(temp);
		}
		return vList;		
	}
	
	
	
	
	
	
	// 시청 기록 영상  c r d
	@GetMapping("/addViews")
	@CrossOrigin
	@ApiOperation(value="회원 시청 영상 저장",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  addViews( @RequestParam("videoName") String videoName,  @RequestParam(value = "userId", required=false, defaultValue="none") String userId )
	{

		if(userId.equals("none"))return -1;  // 토큰 값 없을 때 
		else return myPageService.addViews(userId, videoName );

	}
	

	@GetMapping("/getViews/{reckind}")
	@CrossOrigin
	@ApiOperation(value="회원 시청 영상 조회",notes="성공시 List<Video> 반환, 실패시 null 반환 ")
	public List<VideoDTO.detailResponse>  getViews(@PathVariable String reckind  ,@RequestParam(value = "userId", required=false, defaultValue="none") String userId ) throws IOException
	{	
		
		if(userId.equals("none"))return null;  // 토큰 값 없을 때 
		else return changeResult(myPageService.getViews(userId, reckind));

	}
	
	
	@GetMapping("/deleteViews")
	@CrossOrigin
	@ApiOperation(value="회원 시청 영상 삭제",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  deleteViews(@RequestParam("videoName") String videoName, @RequestParam(value = "userId", required=false, defaultValue="none") String userId 
    )
	{
		

		if(userId.equals("none"))return -1;  // 토큰 값 없을 때 
		else return  myPageService.deleteViews(userId, videoName);  


	}
	
	
	// 좋아요 영상  c r d
	
	
	
	@GetMapping("/addLikes")
	@CrossOrigin
	@ApiOperation(value="회원 좋아요 영상 저장",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  getLikes(@RequestParam("videoName") String videoName, @RequestParam(value = "userId", required=false, defaultValue="none") String userId )
	{
		
		if(userId.equals("none"))return -1;  // 토큰 값 없을 때 
		else return myPageService.addLikes(userId, videoName );
	
	}
	

	@GetMapping("/getLikes")
	@CrossOrigin
	@ApiOperation(value="회원 좋아요 영상 조회",notes="성공시 List<Video> 반환, 실패시 null 반환 ")
	public List<VideoDTO.detailResponse>  getLikes( @RequestParam(value = "userId", required=false, defaultValue="none") String userId 
 ) throws IOException
	{		
		
		if(userId.equals("none"))return null;  // 토큰 값 없을 때 
		else {
			
			System.out.println(userId);
			return changeResult(myPageService.getLikes(userId));
		}		 	
	}
	
	
	@GetMapping("/deleteLikes")
	@CrossOrigin
	@ApiOperation(value="회원 좋아요 영상 삭제",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  deleteLikes(@RequestParam("videoName") String videoName, @RequestParam(value = "userId", required=false, defaultValue="none") String userId 
 )
	{
		
		if(userId.equals("none"))return -1;  // 토큰 값 없을 때 
		else return  myPageService.deleteLikes(userId, videoName);  
				 	
	}
	
	
	
	
	// 다시볼 영상  c r  d 
	
	
	@GetMapping("/addSave")
	@CrossOrigin
	@ApiOperation(value="회원 저장 영상 저장",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  addSave(@RequestParam("videoName") String videoName,  @RequestParam(value = "userId", required=false, defaultValue="none") String userId 
 )
	{
		
		if(userId.equals("none"))return -1;  // 토큰 값 없을 때 
		else return myPageService.addSave(userId, videoName );
	}
	
	
	
	@GetMapping("/getSave")
	@CrossOrigin
	@ApiOperation(value="회원 저장 영상 조회",notes="성공시 List<Video> 반환, 실패시 null 반환 ")
	public List<VideoDTO.detailResponse>  getSave( @RequestParam(value = "userId", required=false, defaultValue="none") String userId ) throws IOException
	{
		
		if(userId.equals("none"))return null;  // 토큰 값 없을 때 
		else return changeResult(myPageService.getSave(userId));
			
	}
	
	
	@GetMapping("/deleteSave")
	@CrossOrigin
	@ApiOperation(value="회원 저장 영상 삭제",notes="성공시 1 반환, 실패시 -1 반환 ")
	public int  deleteSave( @RequestParam("videoName") String videoName,  @RequestParam(value = "userId", required=false, defaultValue="none") String userId 
 )
	{
		
		if(userId.equals("none"))return -1;  // 토큰 값 없을 때 
		else return  myPageService.deleteSave(userId, videoName);  		
		
		 	
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
