package com.metanet.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Comments;
import com.metanet.domain.Users;
import com.metanet.domain.Video;
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
		for(Video v : list)
		{
			if(v.getRecipeKind().equals(userRecKind))
				ret_list.add(v);
		}
		return(ret_list);
	}
	//생성일 기준 정렬해서 댓글 리스트 반환
	public List<Comments> videoCommentList(int videoNumber)
	{
		List<Comments> v = commentsRepo.findByvideoNumber(videoNumber);
		Collections.sort(v, new SortTime());
		return v;
	}
	//비회원일경우 해당 게시글과 같은 분야의 비디오리스트 반환
	public List<Video> videosamekindList(int videoNumber)
	{
		Video v = videoRepo.findByvideoNumber(videoNumber);
		List<Video> list = videoRepo.findAll();
		List<Video> ret_list = new ArrayList<>();
		for(Video v2: list)
		{
			if(v2.getRecipeKind().equals(v.getRecipeKind()))
				ret_list.add(v2);
		}
		return ret_list;
	}
	
}
