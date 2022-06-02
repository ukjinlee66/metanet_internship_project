package com.metanet.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Video;
import com.metanet.repository.VideoRepository;
import com.metanet.service.ListService;

@Service
public class ListServiceImpl implements ListService 
{	
	@Autowired
	VideoRepository videoRepo;
	
	// 기본 검색
	public Optional<Video> Search(String videoTitle)
	{
		return videoRepo.findByvideoTitleIsContaining(videoTitle); 
	}
	
	public Optional<Video> SearchtoLikes(String videoTitle)
	{
		
		return null;
	}
	
	/*
	 * 1. 검색어를 기준으로 jpa를 통해 검색어리스트를 추출한다.
	 * 2. 검색된 리스트에서 해당 요리분야와 맞는 Video객체만 가지고 새로운 리스트를 만들어 반환한다.
	 */
	
	public List<Video> findByvideoTitleContainsAndrecipeKind(String videoTitle, String recipeKind)
	{
//		Optional<Video> newlist = videoRepo.findByvideoTitleContaining(videoTitle);
//		ArrayList<Video> retlist = new ArrayList<>();
//		for(Video v : newlist)
//		{
//			if (v.getRecipeKind() == recipeKind) {
//				retlist.add(v);
//			}
//		}
		return null;
//		return retlist;
	}
	
	public Optional<Video> findCreateTitle(String videoTitle) // 시간순 정렬 검색
	{
		return null;
		//return videoRepo.findByvideoTitleOrderBycrDaDesc(videoTitle); 
	}
	
	public Optional<Video> findViewTitle(String videoTitle) // 조회순 정렬 검색
	{
		return null;
		//return videoRepo.findByvideoTitleOrderByvideoViewDesc(videoTitle); 
	}
}
