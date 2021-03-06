package com.metanet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>
{
	List<Comments> findByvideoNumber(int videoNumber);
	Comments findBycrDa(java.sql.Date crDa);
	Comments findBycommentsNumber(int commentsNumber);
	void deleteBycommentsNumber(int commentsNumber);
}