package com.metanet.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Likes;
import com.metanet.domain.Save;
import com.metanet.domain.Users;
import com.metanet.domain.Video;
import com.metanet.domain.Views;
import com.metanet.repository.LikesRepository;
import com.metanet.repository.SaveRepository;
import com.metanet.repository.SearchWordRepository;
import com.metanet.repository.UsersRepository;
import com.metanet.repository.VideoRepository;
import com.metanet.repository.ViewsRepository;
import com.metanet.service.MyPageService;


@Service
public class MyPageServiceImpl implements MyPageService {

	
	
	@Autowired
	UsersRepository usersRepository;
		
	@Autowired
	ViewsRepository viewsRepository;
	
	@Autowired
	LikesRepository likesRepository;
	
	@Autowired
	SaveRepository saveRepository;
	
	@Autowired
	VideoRepository videoRepository;
	

	
	public int addViews(String userId, String videoName) {
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);

		Optional<Video> findVideo = videoRepository.findByVideoName(videoName);
		
		if(findUsers.isPresent() && findVideo.isPresent() ) {
		
			Views views = new Views();
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    	    
	    views.setUsersNumber(findUsers.get().getUserNumber());
	    views.setVideoNumber( findVideo.get().getVideoNumber());
	    views.setRecentTime(date);
	    
	    System.out.println(views.toString());
	    viewsRepository.save(views);
	    return  1;
	    
		}else {
			return -1;
		}
		
	}
	
	
	public List<Video> getViews(String userId, String reckind){
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		

		System.out.println(findUsers.get().getUserNumber());
		
		List<Views> viewsList = viewsRepository.findByUsersNumber(findUsers.get().getUserNumber() );
	
		System.out.println(viewsList.size());
		
		List<Video> videoList= new ArrayList<Video>();
	
		
		for( Views views : viewsList) {
			Optional<Video> video = videoRepository.findByVideoNumberAndRecipeKind(views.getVideoNumber(),reckind); 			
			if(video.isPresent()) videoList.add(video.get());	
		}
				
		return videoList;		
	};
	
	@Transactional 
	public int deleteViews(String userId, String videoName) {
	
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		Optional<Video> findVideo = videoRepository.findByVideoName(videoName);
		
		viewsRepository.deleteByUsersNumberAndVideoNumber( findUsers.get().getUserNumber(), findVideo.get().getVideoNumber());
		
		return 1; 
	}
	
	
	
	public int addLikes(String userId, String videoName) {

		Optional<Users> findUsers = usersRepository.findByUserId(userId);

		Optional<Video> findVideo = videoRepository.findByVideoName(videoName);
		
		if(findUsers.isPresent() && findVideo.isPresent() ) {
		
			Likes likes = new Likes();
			
			long millis=System.currentTimeMillis();  
		    java.sql.Date date=new java.sql.Date(millis);  
		    
		    likes.setUsersNumber(findUsers.get().getUserNumber());
		    likes.setVideoNumber(findVideo.get().getVideoNumber());
		    likes.setLikesCrda(date);
		    
		    System.out.println(likes.toString());
		    likesRepository.save(likes);

			return  1;
	    
		}else {
			return -1;
		}
		
	}
	
	
	public List<Video> getLikes(String userId){
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		
		List<Likes> likesList = likesRepository.findByUsersNumber(findUsers.get().getUserNumber() );

		List<Video> videoList= new ArrayList<Video>();
		
		for(Likes likes : likesList) {	
			videoList.add(videoRepository.findByvideoNumber(likes.getVideoNumber()));	
		}
		return videoList;
	};
	
	
	@Transactional
	public int deleteLikes(String userId, String videoName) {
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		Optional<Video> findVideo = videoRepository.findByVideoName(videoName);
		
		
		likesRepository.deleteByUsersNumberAndVideoNumber( findUsers.get().getUserNumber(), findVideo.get().getVideoNumber()  );
		
		
		
		return 1; 
	}
	
	
	
	
	
	public int addSave(String userId, String videoName) {
		
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);

		Optional<Video> findVideo = videoRepository.findByVideoName(videoName);
		
		if(findUsers.isPresent() && findVideo.isPresent() ) {
		
			Save save = new Save();
			
			long millis=System.currentTimeMillis();  
		    java.sql.Date date=new java.sql.Date(millis);  
		    save.setUsersNumber(findUsers.get().getUserNumber());
		    save.setVideoNumber(findVideo.get().getVideoNumber());
		    save.setSaveCrda(date);
		    System.out.println(save.toString());
			saveRepository.save(save);
			
			return  1;
	    
		}else {
			return -1;
		}

	}
	
	
	public List<Video> getSave(String userId){
		

		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		
		System.out.println(findUsers.get().getUserNumber());
		List<Save> saveList = saveRepository.findByUsersNumber(findUsers.get().getUserNumber() );
		
		List<Video> videoList= new ArrayList<Video>();
		
		for(Save save : saveList) {
			
			videoList.add(videoRepository.findByvideoNumber( save.getVideoNumber()   ));	
		}
				
		return videoList;
		
		
	};
	
	@Transactional 
	public int deleteSave(String userId, String videoName) {
		
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		Optional<Video> findVideo = videoRepository.findByVideoName(videoName);
		
		
		saveRepository.deleteByUsersNumberAndVideoNumber( findUsers.get().getUserNumber(), findVideo.get().getVideoNumber() );
		
		
		return 1; 
	}
	
	
	
	
}
