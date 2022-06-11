
package com.metanet.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Users;
import com.metanet.domain.Video;
import com.metanet.service.MainPageService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/MainPage")
public class MainPageController {

	@Autowired
	MainPageService mainPageService;


	@GetMapping("/getSearchWordRank")
	@CrossOrigin
	@ApiOperation(value="상단 베너 실시간 랭킹 키워드 제공",notes="성공시 List<String> 반환, size=5 ")
	public List<String> getSearchWordRank(){
		 return mainPageService.getSearchWordRank();
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




