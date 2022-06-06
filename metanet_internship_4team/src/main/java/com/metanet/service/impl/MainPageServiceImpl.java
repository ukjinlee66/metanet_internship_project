package com.metanet.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Users;
import com.metanet.domain.Video;
import com.metanet.repository.UsersRepository;
import com.metanet.repository.VideoRepository;
import com.metanet.service.MainPageService;

@Service
public class MainPageServiceImpl implements MainPageService{

	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	
	public List<String> getRecipeRank(){

		List <Video> videoList = videoRepository.findAll();
				
		Comparator<Video> comparator = new Comparator<Video>() {
		    @Override
		    public int compare(Video a, Video b) {
		        return b.getVideoView() - a.getVideoView();
		    }
		};
		
		Collections.sort(videoList, comparator);
	
		List<String > topNames = new ArrayList<String>();
		for(int i =0; i<5 ; i++) {		
			topNames.add(videoList.get(i).getVideoTitle());
		}
		
		return topNames;
	}

	// 비회원용 
	public List<Video> getVideoListByLevel( String recipeLevel){
		
		
		List<Video> videoList = videoRepository.findByRecipeLevel(recipeLevel);
		
		
		Comparator<Video> comparator = new Comparator<Video>() {
		    @Override
		    public int compare(Video a, Video b) {
		        return b.getVideoView() - a.getVideoView();
		    }
		};
		
		Collections.sort(videoList, comparator);
		
		
		return videoList;
		
		
		
	};
	
	// 회원용 
	public List<Video> getVideoListByLevel(String userId, String recipeLevel){
		
		Users findUser = usersRepository.findByUserId(userId).get();
		
		List<Video> videoList = videoRepository.findByRecipeKindAndRecipeLevel(findUser.getUserReckind(), recipeLevel);
		
		Comparator<Video> comparator = new Comparator<Video>() {
		    @Override
		    public int compare(Video a, Video b) {
		        return b.getVideoView() - a.getVideoView();
		    }
		};
		
		Collections.sort(videoList, comparator);
		
		
		return videoList;
		
	};
	
	
	
}
