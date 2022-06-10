package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Likes;

@Repository
public interface LikesRepository extends JpaRepository< Likes, Long>
{
	int countByvideoNumber(int videoNumber);
	boolean existsByvideoNumber(int videoNumber);
	List<Likes> findByUsersNumber(int usersNumber);
	int deleteByUsersNumberAndVideoNumber (int usersNumber,int videoNumber );
}
