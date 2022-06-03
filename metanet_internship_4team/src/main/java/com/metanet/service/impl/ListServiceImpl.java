package com.metanet.service.impl;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Video;
import com.metanet.repository.VideoRepository;
import com.metanet.service.ListService;


@Service
public class ListServiceImpl implements ListService ,Comparable<Video>
{	
	static class SortTime implements Comparator<Video>
	{
		@Override
		public int compare(Video v, Video v2)
		{
			return v.getCrDa().compareTo(v2.getCrDa());
		}
	}
	
	@Override
	public int compareTo(Video o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Autowired
	VideoRepository videoRepo;
	
	// 기본 검색
	public List<Video> Search(String videoTitle)
	{
		return videoRepo.findByvideoTitleIsContaining(videoTitle); 
	}
	
	public List<Video> SearchCreateTitle(String videoTitle) // 시간순 정렬 검색
	{
		List<Video> first = Search(videoTitle);
		Collections.sort(first, new SortTime());
		return first; 
	}

	
	
//	public Optional<Video> SearchtoLikes(String videoTitle)
//	{
//		
//		return null;
//	}
	
	/*
	 * 1. 검색어를 기준으로 jpa를 통해 검색어리스트를 추출한다.
	 * 2. 검색된 리스트에서 해당 요리분야와 맞는 Video객체만 가지고 새로운 리스트를 만들어 반환한다.
	 */
	
//	public List<Video> findByvideoTitleContainsAndrecipeKind(String videoTitle, String recipeKind)
//	{
////		Optional<Video> newlist = videoRepo.findByvideoTitleContaining(videoTitle);
////		ArrayList<Video> retlist = new ArrayList<>();
////		for(Video v : newlist)
////		{
////			if (v.getRecipeKind() == recipeKind) {
////				retlist.add(v);
////			}
////		}
//		return null;
////		return retlist;
//	}
	
	
	
//	public Optional<Video> SearchViewTitle(String videoTitle) // 조회순 정렬 검색
//	{
//		return videoRepo.findVideoByvideoTitleOrderByvideoViewDesc(videoTitle); 
//	}
}
