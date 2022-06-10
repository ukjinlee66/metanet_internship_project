package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Save;

@Repository
public interface SaveRepository extends JpaRepository<Save, Integer>
{

}
