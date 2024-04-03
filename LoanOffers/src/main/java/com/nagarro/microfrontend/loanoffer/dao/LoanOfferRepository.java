package com.nagarro.microfrontend.loanoffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.microfrontend.loanoffer.entity.LoanOfferDetails;

public interface LoanOfferRepository extends JpaRepository<LoanOfferDetails,Long> {
}
