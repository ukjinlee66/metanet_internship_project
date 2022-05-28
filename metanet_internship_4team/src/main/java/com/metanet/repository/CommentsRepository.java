package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.domain.TestOra;

public interface CommentsRepository extends JpaRepository<TestOra, Integer>

{

}
