package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Likes;
import com.metanet.domain.Save;

@Repository
public interface SaveRepository extends JpaRepository<Save, Integer>
{

	List<Save> findByUsersNumber(int usersNumber);

	
	int deleteByUsersNumberAndVideoNumber (int usersNumber,int videoNumber );
	
}
