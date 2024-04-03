package com.example.GSTIN.gstin.Dao;

import com.example.GSTIN.gstin.Entity.GstinDummyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GstinDummyRepository extends JpaRepository<GstinDummyDetails, Long> {


    Optional<List<GstinDummyDetails>> findByPanNumber(String panNumber);
    Optional<GstinDummyDetails> findByPanNumberAndGstinNumber(String panNumber, String gstinNumber);
}
