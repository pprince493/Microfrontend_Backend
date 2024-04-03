package com.example.GSTIN.gstin.Dao;

import com.example.GSTIN.gstin.Entity.GstinDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface GstinRepository extends JpaRepository<GstinDetails, Long> {
}
