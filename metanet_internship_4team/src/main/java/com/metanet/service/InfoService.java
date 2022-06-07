package com.metanet.service;

import java.util.List;

import com.metanet.domain.Comments;
import com.metanet.domain.Video;


//레시피 상세조회 Service interface
public interface InfoService 
{
	//해당 유저의 번호를 기준으로 관심분야 리스트 반환
	List<Video> userRecKindList(int userNumber);
	//해당 게시글 번호와 동일한 분야의 비디오리스트 반환
	List<Video> videosamekindList(int videoNumber);
	//해당 게시글 번호를 기준으로 댓글 리스트 반환
	List<Comments> videoCommentList(int videoNumber);
}
