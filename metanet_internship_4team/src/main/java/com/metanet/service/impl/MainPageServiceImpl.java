package com.metanet.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.SearchWord;
import com.metanet.domain.Users;
import com.metanet.domain.Video;
import com.metanet.repository.SearchWordRepository;
import com.metanet.repository.UsersRepository;
import com.metanet.repository.VideoRepository;
import com.metanet.service.MainPageService;

@Service
public class MainPageServiceImpl implements MainPageService{

	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	SearchWordRepository searchWordRepository;
	
	
	public List <SearchWord> getSearchWordRank(){

		int FIX_SIZE =5;
		
		List <SearchWord> searchWordList = searchWordRepository.findAll();
				
		Comparator<SearchWord> comparator = new Comparator<SearchWord>() {
		    @Override
		    public int compare(SearchWord a, SearchWord b) {
		        return b.getSearchWordCount() - a.getSearchWordCount();
		    }
		};
		
		Collections.sort(searchWordList , comparator);
		
		if(searchWordList.size()> FIX_SIZE) {
			
			for(int idx=searchWordList.size()-1 ; idx>FIX_SIZE-1 ; idx--){
				searchWordList.remove(idx);
			}
		}
		
		
		return searchWordList;
	}
	
	

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
	public List<Video> getVideoListByLevel( ){
		
		
		List<Video> videoList = videoRepository.findAll();
		List<Video> resultList  = new ArrayList<Video>();
		
		Comparator<Video> comparator = new Comparator<Video>() {
		    @Override
		    public int compare(Video a, Video b) {
		        return b.getVideoView() - a.getVideoView();
		    }
		};
		
		Collections.sort(videoList, comparator);
		
		
		int listSize = 5;
		if(videoList.size()<listSize) listSize = videoList.size();
		
		for( int i =0; i<listSize; i++ ) {
			resultList.add(videoList.get(i));
		}
		
		// 5개반 주어야함 
		return resultList;
		
	};
	
	// 회원용 
	public List<Video> getVideoListByLevel(String userId){
		
		Users findUser = usersRepository.findByUserId(userId).get();
		
		List<Video> videoList = videoRepository.findByrecipeKind(findUser.getUserRecKind());
		List<Video> resultList  = new ArrayList<Video>();
		
		
		Comparator<Video> comparator = new Comparator<Video>() {
		    @Override
		    public int compare(Video a, Video b) {
		        return b.getVideoView() - a.getVideoView();
		    }
		};
		
		Collections.sort(videoList, comparator);
		
		
		int listSize = 5;
		if(videoList.size()<listSize) listSize = videoList.size();
		
		for( int i =0; i<listSize; i++ ) {
			resultList.add(videoList.get(i));
		}
		
		// 5개반 주어야함 
		return resultList;
		

	};
	
	
	
}
