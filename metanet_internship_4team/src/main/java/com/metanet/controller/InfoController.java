package com.metanet.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metanet.domain.Comments;
import com.metanet.domain.Video;
import com.metanet.domain.DTO.VideoDTO;
import com.metanet.repository.VideoRepository;
import com.metanet.service.InfoService;
import com.metanet.service.MyPageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;



@RestController
@RequestMapping("/Info")
public class InfoController 
{
	@Autowired
	private InfoService infoService; // InfoService service
	
	@Autowired
	private  MyPageService myPageService ;
	
	
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
		
	
	
	
	
	
	
	
	// 주웅 추가 (영상 상세 정보에 대한 crud)
	
	@PostMapping("/addDetail")
	@CrossOrigin
	@ApiOperation(value="레시피 정보 추가",notes="성공시 생성된 VideoNumber, 실패시 -1")
	public int addDetail( 
			//@ApiParam(value="새로운 레시피",required=true) 
			VideoDTO.addDetailRequest newDetail)
	{
		

		infoService.saveDetail(newDetail);		
		
		
		Optional<Video> findVideo = videoRepo.findByVideoTitle( newDetail.getVideoTitle() );
		
		if(findVideo.isPresent()) return findVideo.get().getVideoNumber();
		else return -1;	

	}
	
	
	@GetMapping("/deleteDetail")
	@CrossOrigin
	@ApiOperation(value="해당 레시피 정보 삭제",notes="레시피아이디를 통한 상세정보 삭제, 성공시 1 반환")
	public int deleteDetail(
			@ApiParam(value="레시피 아이디",required=true) @RequestParam int videoNumber 
			)
	{
		return infoService.deleteDetail(videoNumber);		
	}
	

	@PostMapping("/updateDetail")
	@CrossOrigin
	@ApiOperation(value="해당 레시피 정보 업데이트",notes="Video 객체로 상세정보 업데이트, 성공시 1 반환 ")
	public int updateDetail(
			VideoDTO.updateDetailRequest updateDetail
			)
	{	
		return infoService.updateDetail(updateDetail);
		
	}
	
	
	
	// 주웅 추가  (좋아요 판별여부, 및 좋아요 삭제 ) 
	
	
	@GetMapping("/isLiked")
	@CrossOrigin
	@ApiOperation(value="레시피에 대한 좋아요 여부 확인 ",notes=" 좋아요일시 1, 좋아요가 아닐시 -1, 비회원일시 -1 반환")
	public boolean isLiked(
			@RequestParam int videoNumber ,
			@RequestParam(value = "userId", required=false, defaultValue="-1") int userNumber
			)
	{
	
		if(userNumber == -1) return false;  // 비회원이라면  false을 반환함 
		else return myPageService.isLike(videoNumber, userNumber);
		
	}
	
	
	@GetMapping("/deleteLikes")
	@CrossOrigin
	@ApiOperation(value="회원 레시피 좋아요 삭제",notes="회원 번호, , 성공시 1 반환")
	public int deleteDetail(
			@ApiParam(value="레시피 아이디",required=true) @RequestParam String userId,
			String videoName
			)
	{
	
		myPageService.deleteLikes(userId, videoName);
		return 1;
	}
	
	
	
	
	// 주웅 추가  (저장영상  판별여부, 및 좋아요 삭제 ) 
	
	
	@GetMapping("/isSaved")
	@CrossOrigin
	@ApiOperation(value="레시피에 대한 좋아요 여부 확인 ",notes=" 좋아요일시 1, 좋아요가 아닐시 -1, 비회원일시 -1 반환")
	public boolean isSaved(
			@RequestParam int videoNumber ,
			@RequestParam(value = "userId", required=false, defaultValue="-1") int userNumber
			)
	{
	
		if(userNumber == -1) return false;  // 비회원이라면 false을 반환함 
		else return myPageService.isSave(videoNumber, userNumber);
		
	}
	
	
	@GetMapping("/deleteSave")
	@CrossOrigin
	@ApiOperation(value="회원 레시피 좋아요 삭제",notes="회원 번호, , 성공시 1 반환")
	public int deleteSave(
			@ApiParam(value="레시피 아이디",required=true) @RequestParam String userId,
			String videoName
			)
	{
	
		myPageService.deleteSave(userId, videoName);
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
}
