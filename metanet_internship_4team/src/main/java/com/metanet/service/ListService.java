package com.metanet.service;

import java.util.List;

import com.metanet.domain.Video;

public interface ListService 
{
	List<Video> Search(String videoTitle); // 기본 검색
	List<Video> SearchCreateTitle(String videoTitle); // 시간순 정렬 검색
	//Optional<Video> SearchViewTitle(String videoTitle); // 조회순 정렬 검색
	//Optional<Video> SearchtoLikes(String videoTitle); // 인기순 정렬 검색
	//List<Video> findByvideoTitleContainsAndrecipeKind(String videoTitle, String recipeKind); //해당 레시피 종류의 리스트 검색
}
