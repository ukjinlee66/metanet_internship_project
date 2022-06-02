package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository <Video, Integer>
{

	Video findByvideoNumber(int videoNumber);

}
