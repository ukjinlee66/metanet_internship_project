package com.metanet.service;

import java.util.List;

import com.metanet.domain.SearchWord;
import com.metanet.domain.Video;

public interface MainPageService {


	public List <SearchWord> getSearchWordRank();	

	//public List<String> getRecipeRank();


	// 비회원용 
	public List<Video> getVideoListByLevel( );
	
	// 회원용 
	public List<Video> getVideoListByLevel(String userId);
	
	
}
