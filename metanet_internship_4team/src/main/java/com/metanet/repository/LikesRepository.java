package com.metanet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Likes;

@Repository
public interface LikesRepository extends JpaRepository< Likes, Integer>
{
	int countByvideoNumber(int videoNumber);
	
	boolean existsByvideoNumber(int videoNumber);
	List<Likes> findByUsersNumber(int usersNumber);
	int deleteByUsersNumberAndVideoNumber (int usersNumber,int videoNumber );
	Likes findByvideoNumber(int videoNumber);
	
	@Query(value = "SELECT m.video_number FROM Likes m where m.video_number > 0 group by m.video_number order by count(m.video_number) desc", nativeQuery = true)
	List<Integer> SearchtoLike(List<Likes> ar);
	
	Optional<Likes> findByUsersNumberAndVideoNumber (int usersNumber,int videoNumber );
}
