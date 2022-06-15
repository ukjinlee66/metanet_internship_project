package com.metanet.service;

import java.util.List;

import com.metanet.domain.Video;

public interface MyPageService {
	
	public int addViews(String userId, String videoName);	
	public List<Video> getViews(String userId, String reckind);
	public int deleteViews(String userId, String videoName);
	
	
	public int addLikes(String userId, String videoName);
	public List<Video> getLikes(String userId);	
	public int deleteLikes(String userId, String videoName);	

	
	public int addSave(String userId, String videoName);
	public List<Video> getSave(String userId);
	public int deleteSave(String userId, String videoName);	
	
	
	//좋아요 체크여부 확인 
	public int isLike( int videoNumber, int userNumber);	
	
	
	
	
}

