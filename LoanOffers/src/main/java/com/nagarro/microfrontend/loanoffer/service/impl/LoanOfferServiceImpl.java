package com.nagarro.microfrontend.loanoffer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microfrontend.loanoffer.dao.LoanOfferRepository;
import com.nagarro.microfrontend.loanoffer.dto.ApiResponse;
import com.nagarro.microfrontend.loanoffer.entity.LoanOfferDetails;
import com.nagarro.microfrontend.loanoffer.exception.ResourceNotFound;
import com.nagarro.microfrontend.loanoffer.service.LoanOfferService;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

	private final LoanOfferRepository loanOfferRepository;

	@Autowired
	public LoanOfferServiceImpl(LoanOfferRepository loanOfferRepository) {
		this.loanOfferRepository = loanOfferRepository;
	}

	@Override
	public ApiResponse getLoanOffers() {
		final List<LoanOfferDetails> offers=loanOfferRepository.findAll();
		
		if(offers.size()==0) {
			throw new ResourceNotFound("No Offers Availabe");
		}
		
		ApiResponse response = new ApiResponse();
		response.setStatusCode(200);
		response.setMessage("Success");
		response.setData(offers);

		return response;
	}
}
