package com.metanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Save;
import com.metanet.domain.Views;

@Repository
public interface ViewsRepository extends JpaRepository<Views, Integer>
{

	List<Views> findByUsersNumber(int usersNumber);
	
	int deleteByUsersNumberAndVideoNumber (int usersNumber,int videoNumber );
	
	
	
}
