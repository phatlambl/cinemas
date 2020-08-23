package com.cinemas.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinemas.spring.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByName(String name);
}
