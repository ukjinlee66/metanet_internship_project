package com.metanet.service.impl;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Comments;
import com.metanet.domain.Users;
import com.metanet.domain.Video;
import com.metanet.domain.DTO.VideoDTO;
import com.metanet.repository.CommentsRepository;
import com.metanet.repository.UsersRepository;
import com.metanet.repository.VideoRepository;
import com.metanet.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService
{
	
	@Autowired
	private UsersRepository usersRepo;
	
	@Autowired
	private VideoRepository videoRepo;
	
	@Autowired
	private CommentsRepository commentsRepo;
	
	static class SortTime implements Comparator<Comments>
	{
		@Override
		public int compare(Comments c1, Comments c2)
		{
			return c1.getCrDa().compareTo(c2.getCrDa());
		}
	}
	//회원일 경우 해당 게시글을 참조할 때 회원의 관심분야와 동일한 리스트 반환
	public List<Video> userRecKindList(int userNumber)
	{
		Users u = usersRepo.findByuserNumber(userNumber);
		String userRecKind = u.getUserRecKind(); // 게시글의 접속한 유저의 관심분야
		List<Video> list = videoRepo.findAll(); // 전체비디오테이블
		List<Video> ret_list = new ArrayList<>();
		int cnt=0;
		for(Video v : list)
		{
			if(cnt==3) break;
			if(v.getRecipeKind().equals(userRecKind))
			{
				ret_list.add(v);
				cnt++;
			}
		}
		return(ret_list);
	}
	//생성일 기준 정렬해서 댓글 리스트 반환
	public List<Comments> videoCommentList(int videoNumber)
	{
		if(videoNumber == 0) {
			return new ArrayList<Comments>();
		}
		try {
			List<Comments> v = commentsRepo.findByvideoNumber(videoNumber);
			if (v.isEmpty())
				return new ArrayList<Comments>();
			Collections.sort(v, new SortTime());
			return v;
		}
		catch(NullPointerException e)
		{
			System.out.println("videoCommentList Error!");
			return new ArrayList<Comments>();
		}
	}
	//비회원일경우 해당 게시글과 같은 분야의 비디오리스트 반환
	public List<Video> videosamekindList(int videoNumber)
	{
		Video v = videoRepo.findByvideoNumber(videoNumber);
		List<Video> list = videoRepo.findAll();
		List<Video> ret_list = new ArrayList<>();
		int cnt=0;
		for(Video v2: list)
		{
			if (cnt==3) break;
			if(v2.getRecipeKind().equals(v.getRecipeKind()))
			{
				ret_list.add(v2);
				cnt++;
			}
		}
		return ret_list;
	}
	
	
	@Transactional
	public void deleteComment(int commentsNumber)
	{
		try {
			System.out.println("commentsNumber : "+commentsNumber);
			Comments c = commentsRepo.findBycommentsNumber(commentsNumber);
			c.setDeDa(new java.sql.Date(System.currentTimeMillis()));
			System.out.println("comments object : "+c);
			commentsRepo.save(c);
		}
		catch(NullPointerException e)
		{
			System.out.println("DeleteComment Error!");
		}
	}
	
	
	// 주웅 상세정보 삭제 

	@Transactional 
	public boolean deleteDetail(int videoNumber) 
	{
		try 
		{
			Video findVideo  = videoRepo.findByvideoNumber(videoNumber);
			videoRepo.delete(findVideo);
			return true;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	};
	
	
	// 주웅 상세정보 업데이트 
	@Transactional 	
	public int updateDetail(VideoDTO.updateDetailRequest updateDetail) {
		
		
		Video updateVideo = videoRepo.findByvideoNumber(updateDetail.getVideoNumber());

		updateVideo= updateDetail.transferTo(updateVideo);
		

		// 날짜생성 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    updateVideo.setUpDa(date);
		
		videoRepo.save(updateVideo);
		
		return 1 ; 
	};
	
	
	@Transactional 
	public void saveDetail(VideoDTO.addDetailRequest newDetail) {
	
		Video newVideo =  new Video();
		newVideo = newDetail.transferTo(newVideo);
		
		// 날짜생성 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    newVideo.setCrDa(date);

		videoRepo.save(newVideo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
