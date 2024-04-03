package com.nagarro.cinservice.dao;

import com.nagarro.cinservice.entity.CinDummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinDummyRepository extends JpaRepository<CinDummyEntity, Long> {

}