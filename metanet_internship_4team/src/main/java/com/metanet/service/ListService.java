package com.metanet.service;

import java.util.List;

import com.metanet.domain.Video;

public interface ListService 
{
	List<Video> SearchAll(); // 검색
	List<Video> SearchLevel(String recipeLevel); // findByLevel
	List<Video> SearchKind(String recipeKind); // findByKind
	List<Video> Search(String videoTitle); // 기본 검색
	List<Video> SearchKind(String videoTitle, String recipeKind); // 분야 검색
	List<Video> SearchCreateTitle(List<Video> arr); // 시간순 정렬 검색
	List<Video> SearchViewTitle(List<Video> arr); // 조회순 정렬 검색
	List<Video> SearchtoLikes(List<Video> arr); // 좋아요순 정렬 검색
	//List<Video> findByvideoTitleContainsAndrecipeKind(String videoTitle, String recipeKind); //해당 레시피 종류의 리스트 검색
}
