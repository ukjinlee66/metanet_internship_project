
package com.metanet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.SearchWord;
import com.metanet.domain.Video;
import com.metanet.domain.DTO.VideoDTO;
import com.metanet.domain.DTO.VideoDTO.detailResponse;
import com.metanet.repository.VideoRepository;
import com.metanet.service.MainPageService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/MainPage")
public class MainPageController {

	@Autowired
	MainPageService mainPageService;

	@Autowired	
	VideoRepository videoRepository;

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
	
	
	
	
	
	@GetMapping("/getSearchWordRank")
	@CrossOrigin
	@ApiOperation(value="상단 베너 실시간 랭킹 키워드 제공",notes="성공시 List<String> 반환, size=5 ")
	public List <SearchWord> getSearchWordRank(){
		 		
		return mainPageService.getSearchWordRank();

	}
	
	

	@GetMapping("/getMainVideoList")
	@CrossOrigin
	@ApiOperation(value="상단 베너 실시간 랭킹 키워드 제공",notes="성공시 List<String> 반환, size=5 ")
	public List<VideoDTO.detailResponse> getMainVideoList( @RequestParam(value = "userId", required=false, defaultValue="none") String userId ) throws IOException{
		
		if(userId.equals("none")) return changeResult(mainPageService.getVideoListByLevel()); //로그인이 안되어있다면  단순 조회수 		
		else return changeResult(mainPageService.getVideoListByLevel(userId)); // 로그인이 되어있다면 사용자 기반 조회수 

	}
	
//	
//	@GetMapping("/getDetail")
//	@CrossOrigin
//	@ApiOperation(value="상단 베너 실시간 랭킹 키워드 제공",notes="성공시 List<String> 반환, size=5 ")
//	public VideoDTO.detailResponse getMainVideoList( @RequestParam int videoNumber ) throws IOException{
//		
//		Video video = videoRepository.findByvideoNumber(videoNumber);
//
//		VideoDTO.detailResponse response = new VideoDTO.detailResponse();
//		response.transferFrom(video);
//		return response;
//	}
	
	
	
	
	@GetMapping("/getDetail")
	@CrossOrigin
	@ApiOperation(value="상단 베너 실시간 랭킹 키워드 제공",notes="성공시 List<String> 반환, size=5 ")
	public VideoDTO.detailResponse getMainVideoList( @RequestParam int videoNumber ) throws IOException{
		
		Video video = videoRepository.findByvideoNumber(videoNumber);

		VideoDTO.detailResponse response = videoDTO.new detailResponse();
		response.transferFrom(video);
		return response;
	}
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping("/getRecipeRank")
	@CrossOrigin
	@ApiOperation(value="상단 베너 실시간 랭킹 레세피 제공",notes="성공시 List<String> 반환, size=5 ")
	public List<String>  getRecipeRank()
	{
		 return mainPageService.getRecipeRank();
	}
	*/
	
	
	/*
	@GetMapping("/getVideo/{level}")
	@CrossOrigin
	@ApiOperation(value="메인화면 난이도 별 리스트 제공 ",notes="성공시 List<String> 반환 ")
	public List<Video> getVideo ( @PathVariable String level , HttpServletRequest request
								)
	{
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			Users users = (Users)session.getAttribute("info");
		
			List<Video> videoList = mainPageService.getVideoListByLevel( users.getUserId(), level);
			return videoList;
			
		} else {
			System.out.println("You need to login first login first");
			return mainPageService.getVideoListByLevel(level);
		}
		
		

	}
	*/

	/*
	@PostMapping("/serch")
	public List<Video>  signUpAccount(  @RequestParam String videoTitle )
	{
		System.out.println("IN: "+videoTitle);
		List<Video> v = service.Search(videoTitle);
		return v;
	}
	*/
	
}




