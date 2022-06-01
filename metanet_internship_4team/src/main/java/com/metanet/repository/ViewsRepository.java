package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Views;

@Repository
public interface ViewsRepository extends JpaRepository<Views, Integer>
{

}
