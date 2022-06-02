package com.metanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>
{

}
