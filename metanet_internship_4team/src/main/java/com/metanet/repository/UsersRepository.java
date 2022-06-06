package com.metanet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>
{

	Optional<Users> findByUserId(String userId);
	
	Optional<Users> findByUserIdAndUserPassword (String userId, String password);

	Optional<Users> findByUserNameAndUserPhoneNumberAndUserEmail( String userName, String userPhoneNumber, String usersEmail);
	
	Optional<Users> findByUserIdAndUserNameAndUserEmail( String userId,  String userName, String usersEmail );
	
}
