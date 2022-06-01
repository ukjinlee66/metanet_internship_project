package com.metanet.service;

import java.util.List;
import java.util.Optional;

import com.metanet.domain.Video;

public interface ListService 
{
	List<Video> Search(String search, int page);
	Optional<Video> findByvideoTitleContains(String videoTitle); // 기본 검색 쿼리
}
