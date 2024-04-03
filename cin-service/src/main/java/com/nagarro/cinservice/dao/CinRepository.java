package com.nagarro.cinservice.dao;

import com.nagarro.cinservice.entity.CinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinRepository extends JpaRepository<CinEntity, Long> {

}


