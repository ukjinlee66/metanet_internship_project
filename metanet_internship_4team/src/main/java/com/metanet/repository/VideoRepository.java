package com.metanet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository <Video, Long>
{
	Optional<Video> findByvideoTitleIsContaining(String videoTitle);
	Video findByvideoNumber(int videoNumber);
//	Optional<Video> findByvideoTitleOrderBycrDaDesc(String videoTitle); // 시간순 정렬 검색
//	Optional<Video> findByvideoTitleOrderByvideoViewDesc(String videoTitle); // 조회순 정렬 검색
}
