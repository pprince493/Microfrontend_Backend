package com.nagarro.postalservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.postalservice.entity.PostalRecord;

@Repository
public interface PostalRecordDao extends JpaRepository<PostalRecord,Long> {
	
	
	PostalRecord findByPinCode(long pinCode);

}
