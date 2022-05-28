package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.domain.Report;

public interface QuestionRepository extends JpaRepository<Report, Integer> {

}
