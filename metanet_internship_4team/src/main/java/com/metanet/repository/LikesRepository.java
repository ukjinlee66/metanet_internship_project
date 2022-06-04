package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Likes;

@Repository
public interface LikesRepository extends JpaRepository< Likes, Integer>
{
	long countByvideoNumber(int videoNumber);
}
