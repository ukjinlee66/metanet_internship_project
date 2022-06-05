package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Likes;

@Repository
public interface LikesRepository extends JpaRepository< Likes, Long>
{
	int countByvideoNumber(int videoNumber);

//	@Query("SELECT COUNT(l.videoNumber)>0"+
//			"FROM LIKES l" +
//			"WHERE l.videoNumber =:videoNumber")
//	boolean exists(@Param("videoNumber") int videoNumber);
}
