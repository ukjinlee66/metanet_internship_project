package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository <Video, String>
{
	List<Video> findByvideoTitleIsContaining(String videoTitle);
	List<Video> findByrecipeKind(String recipeKind);
	List<Video> findByrecipeLevel(String recipeLevel);
	Video findByvideoNumber(int videoNumber);
	//Optional<Video> findVideoByvideoTitleOrderByvideoViewDesc(String videoTitle); // 조회순 정렬 검색
}
