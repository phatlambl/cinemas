package com.cinemas.spring.repositories;




import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinemas.spring.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query(value = "select `userid` from user where name = :nameuser", nativeQuery = true)
	public Integer findByAccountname(@Param("nameuser") String name);
	
	User findByUsername(String userName);
}
