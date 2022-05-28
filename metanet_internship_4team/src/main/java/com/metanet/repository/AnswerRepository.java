package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.domain.Report;

public interface AnswerRepository extends JpaRepository<Report, Integer> {

}
