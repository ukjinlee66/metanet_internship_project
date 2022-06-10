package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.domain.SearchWord;

public interface SearchWordRepository extends JpaRepository<SearchWord, Integer>
{

}

