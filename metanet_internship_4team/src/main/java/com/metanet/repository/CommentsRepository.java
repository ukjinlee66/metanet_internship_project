package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>

{
	List<Comments> findByvideoNumber(int videoNumber);
}
