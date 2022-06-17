package com.metanet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository <Video, String>
{
	List<Video> findByvideoTitleIsContaining(String videoTitle);
	List<Video> findByrecipeKind(String recipeKind);
	List<Video> findByrecipeLevel(String recipeLevel);
	Video findByvideoNumber(int videoNumber);
	Optional<Video> findByVideoNumberAndRecipeKind (int videoNumber, String recipeKind);
	List<Video> findByRecipeLevel(String recipeLevel);
	List<Video> findByRecipeKindAndRecipeLevel(String UserReckind, String recipeLevel);

	Optional<Video> findByVideoName(String videoName);
	Optional<Video> findByVideoTitle(String videoTitle);
	

	@Modifying
	@Query("update Video v set v.videoView = v.videoView + 1 where v.videoNumber = :videoNumber")
	int updateView(int videoNumber);

}
