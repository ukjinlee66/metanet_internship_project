package com.metanet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Comments;
import com.metanet.domain.Video;
import com.metanet.repository.VideoRepository;
import com.metanet.service.InfoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/Info")
public class InfoController 
{
	@Autowired
	private InfoService infoService; // InfoService service
	
	@Autowired
	private VideoRepository videoRepo;
	
	@GetMapping("/detail")
	@CrossOrigin
	@ApiOperation(value="해당 레시피 정보 조회",notes="레시피아이디를 통한 상세정보 조회")
	public Video detail(
			@ApiParam(value="레시피 아이디",required=true) @RequestParam int videoNumber 
			)
	{
		return(videoRepo.findByvideoNumber(videoNumber));
	}
	
	@GetMapping("/comments")
	@CrossOrigin
	@ApiOperation(value="해당 레시피 댓글정보 조회",notes="레시피아이디를 통한 댓글정보 조회")
	public List<Comments> commetslist(
			@ApiParam(value="레시피 아이디",required=true) @RequestParam int videoNumber 
			)
	{
		return(infoService.videoCommentList(videoNumber));
	}
	
	@GetMapping("/detailList")
	@CrossOrigin
	@ApiOperation(value="비회원일 경우 해당 레시피 사이드 리스트 조회",notes="레시피아이디를 통한 리스트 정보 조회")
	public List<Video> detaillist
	(
			@ApiParam(value="레시피 아이디",required=true) @RequestParam int videoNumber 
			)
	{
		return(infoService.videosamekindList(videoNumber));
	}
	
	@GetMapping("/detailUserList")
	@CrossOrigin
	@ApiOperation(value="회원일 경우 해당 레시피 사이드 리스트 조회",notes="회원 관심분야를 통한 리스트 정보 조회")
	public List<Video> detailuserlist
	(
			@ApiParam(value="회원 번호",required=true) @RequestParam int userNumber 
			)
	{
		return(infoService.userRecKindList(userNumber));
	}
	
}
