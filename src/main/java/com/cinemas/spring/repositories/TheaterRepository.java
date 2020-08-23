package com.cinemas.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemas.spring.entities.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer>{

}
