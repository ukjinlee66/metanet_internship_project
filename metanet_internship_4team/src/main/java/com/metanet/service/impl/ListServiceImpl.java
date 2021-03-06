package com.metanet.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Likes;
import com.metanet.domain.Video;
import com.metanet.repository.LikesRepository;
import com.metanet.repository.VideoRepository;
import com.metanet.service.ListService;


@Service
public class ListServiceImpl implements ListService
{	
	@Autowired
	private VideoRepository videoRepo;
	
	@Autowired
	private LikesRepository likesRepo;
	
	/*
	 * 1. 검색어를 기준으로 jpa를 통해 검색어리스트를 추출한다.
	 * 2. 정렬이 필요할 경우 Comparator<Video>를 정렬기준에 따라 정의해서 정렬한다.
	 * 3. 해당 결과를 List<Video> 형태로 반환한다.
	 */
	
	static class SortTime implements Comparator<Video>
	{
		@Override
		public int compare(Video v, Video v2)
		{
			return v.getCrDa().compareTo(v2.getCrDa());
		}
	}
	
	static class SortView implements Comparator<Video>
	{
		@Override
		public int compare(Video v, Video v2)
		{
			if (v.getVideoView() > v2.getVideoView())
				return 1;
			else if (v.getVideoView() == v2.getVideoView())
				return 0;
			else
				return -1;
		}
	}
	
	static class SortLike implements Comparator<Video>
	{
		@Autowired
		private LikesRepository likesRepo;
		
		@Override
		public int compare(Video v, Video v2)
		{	
			try 
			{
				if (likesRepo.countByvideoNumber(v.getVideoNumber()) >= likesRepo.countByvideoNumber(v2.getVideoNumber()))
					return 1;
				else
					return -1;
			}
			catch(NullPointerException e)
			{
				return -1;
			}
		}
	}
	// 검색
	@Override
	public List<Video> SearchAll() 
	{
		return videoRepo.findAll();
	}
	@Override
	public List<Video> SearchLevel(String recipeLevel) // findByLevel
	{
		return videoRepo.findByrecipeLevel(recipeLevel);
	}
	@Override
	public List<Video> SearchKind(String recipeKind) // findByKind
	{
		return videoRepo.findByrecipeKind(recipeKind);
	}
	
	// 기본 검색
	public List<Video> Search(String videoTitle)
	{
		return videoRepo.findByvideoTitleIsContaining(videoTitle); // 기본 검색어에 따른결과를 리스트로 반환 ex) (%검색어%)
	}
	
	public List<Video> SearchCreateTitle(List<Video> arr) // 시간순 정렬 검색
	{
		List<Video> first = arr;//검색어에따른 리스트
		Collections.sort(first, new SortTime().reversed());// 해당 게시글의 시간을 비교해서 정렬
		return first; 
	}

	public List<Video> SearchViewTitle(List<Video> arr) // 조회순 정렬 검색
	{
		List<Video> first = arr; //검색어에따른 리스트
		Collections.sort(first, new SortView().reversed()); // 해당 게시글의 조회수를 비교해서 정렬
		return first;
	}
	
	public List<Video> SearchtoLikes(List<Video> arr) // 좋아요순 정렬 검색
	{
		try
		{
			List<Likes> temp = new ArrayList<>();
			List<Video> temp2 = new ArrayList<>();
			List<Likes> alltemp = likesRepo.findAll();
			for (Video v : arr)
			{
				for (Likes l : alltemp)
				{
					if(l.getVideoNumber() == v.getVideoNumber())
					{
						temp.add(l);
						break;
					}
				}
			}
			List<Integer> check = likesRepo.SearchtoLike(temp);
			
			for (Integer v : check)
				temp2.add(videoRepo.findByvideoNumber(v));
			
			for(Video t : temp2)
				arr.remove(t);
			
			temp2.addAll(arr);
			
			return temp2;
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return new ArrayList<Video>();
		}
	}
	
	public List<Video> SearchKind(String videoTitle, String recipeKind) // 분야 검색
	{
		List<Video> first = Search(videoTitle);
		List<Video> second = new ArrayList<>();
		for(Video v : first)
		{
			try {
				if(v.getRecipeKind().equals(recipeKind))
					second.add(v);
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
		}
		if(second.isEmpty())
			return (new ArrayList<>());
		else
			return second;
	}
	
	public List<Video> SearchLevel(String videoTitle, String recipeLevel) // 분야 검색
	{
		List<Video> first = Search(videoTitle);
		List<Video> second = new ArrayList<>();
		for(Video v : first)
		{
			try {
				if(v.getRecipeLevel().equals(recipeLevel))
					second.add(v);
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
		}
		if(second.isEmpty())
			return (new ArrayList<>());
		else
			return second;
	}
	
	@Transactional
	public int updateView(int videoNumber) {
	        return videoRepo.updateView(videoNumber);
	    }
}