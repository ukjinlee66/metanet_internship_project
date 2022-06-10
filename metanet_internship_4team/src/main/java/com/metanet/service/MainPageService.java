package com.metanet.service;

import java.util.List;

import com.metanet.domain.Video;

public interface MainPageService {


	
	public List<String> getSearchWordRank();

		
	//public List<String> getRecipeRank();


	// 비회원용 
	public List<Video> getVideoListByLevel( String level);
	
	// 회원용 
	public List<Video> getVideoListByLevel(String userId, String level);
	
	
}
