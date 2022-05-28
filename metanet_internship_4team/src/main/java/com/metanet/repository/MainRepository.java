package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.domain.Video;

public interface MainRepository extends JpaRepository<Video, Integer> {

}
