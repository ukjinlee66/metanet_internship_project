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
	
	@Value("${file.path}")
	private String fileRealPath;
	
	@Value("${ffmpg.path}")
	private String ffmpgRealPath;
	
	
	
	
	
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
	public int isLiked(
			@RequestParam int videoNumber ,
			@RequestParam(value = "userId", required=false, defaultValue="-1") int userNumber
			)
	{
	
		if(userNumber == -1) return -1;  // 비회원이라면  -1을 반환함 
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
	
	
	
	// 주웅 추가 (파일 업로드 다운로드 )
	
	
	
	

	
	/*
	
	@PostMapping("/fileUpload")
	@CrossOrigin
	@ApiOperation(value="파일 업로드 ",notes="회원 번호, , 성공시 1 반환")
	public String uploadSingle(@RequestParam("files") MultipartFile uploadFile) throws Exception 
	{
		
		// 저장할 base url  :  fileRealPath
		// ffmpeg , ffprobe .exe 위치 경로  
		
		//1. 영상을 저장할 path 설정 
		String originalFileName = uploadFile.getOriginalFilename();
		String saveFilePath = fileRealPath +originalFileName;

		//2. 영상 저장 
		File dest = new File( saveFilePath);
		uploadFile.transferTo(dest);
		
		/*
		
		//2.ts를 저장할 path 설정 
		String onlyFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
		final String tsPath = fileRealPath + onlyFileName;
		
		//3.디렉토리 설정 
		File tsPathFile = new File(tsPath);
    	if(! tsPathFile.exists()) tsPathFile.mkdir();
    	

    	// ffmpeg 및 ffprobe 객체 생성 
    	
		FFmpeg ffmpeg = new FFmpeg(ffmpgRealPath+"ffmpeg");
		FFprobe ffprobe = new FFprobe(ffmpgRealPath+"ffprobe");

			
    	
    	
	
		
		File dest = new File( fileRealPath +originalfileName);
		
		
		file.transferTo(dest);
		
		
		
		String ffmpegPath = ffmpgRealPath+"ffmpeg";
		String ffprobePath = ffmpgRealPath+"ffprobe";
	
		FFmpeg ffmpeg =  new FFmpeg ("dd");
		FFprobe ffprobe = new FFprobe("dd"); 
		
		
		
		
		
		
		
		
		System.out.println("test2");
		*/
		
		return "good";
	}
	
	/*
	@PostMapping("/hlsMake")
	@ApiOperation(value="파일 업로드 ",notes="회원 번호, , 성공시 1 반환")
	public String hlsMake() throws Exception 
	{
		
		String ffmpegPath = ffmpgRealPath+"ffmpeg";
		String ffprobePath = ffmpgRealPath+"ffprobe";
	
		
	   	final String FFMPEG_PATH = ffmpegProperties.getPath();
    	final String FFMPEG = ffmpegProperties.getFfmpeg();
    	final String FFPROBE = ffmpegProperties.getFfprobe();

		
		
	}
	
	
	
	// 이건 ffmpeg test 입니다. 삭제할 예장합니다. 
	@PostMapping("/hlstest")
	@ApiOperation(value="파일 업로드 ",notes="회원 번호, , 성공시 1 반환")
	public String hlsMake() throws Exception 
	{
		

		
		return "good";
	}
	
	*/
	
	
	
	
}
