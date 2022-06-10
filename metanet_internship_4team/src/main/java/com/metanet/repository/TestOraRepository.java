package com.metanet.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metanet.domain.TestOra;


@Repository
public interface TestOraRepository extends JpaRepository<TestOra, Integer>
{
	List<TestOra> findByuserId(int userId);
}
