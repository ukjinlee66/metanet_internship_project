package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository <Video, Long>
{
	List<Video> findByvideoTitleIsContaining(String videoTitle);
	Video findByvideoNumber(int videoNumber);
	//Optional<Video> findVideoByvideoTitleOrderByvideoViewDesc(String videoTitle); // 조회순 정렬 검색
}
