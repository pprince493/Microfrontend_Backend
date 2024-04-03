package com.nagarro.kycservice.dao;

import com.nagarro.kycservice.entity.PanDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanImageRepository extends JpaRepository<PanDetails, Long> {

}
