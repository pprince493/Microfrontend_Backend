package com.nagarro.kycservice.dao;

import com.nagarro.kycservice.entity.PanDummyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanDummyDetailsRepository extends JpaRepository<PanDummyDetails, String> {
}
