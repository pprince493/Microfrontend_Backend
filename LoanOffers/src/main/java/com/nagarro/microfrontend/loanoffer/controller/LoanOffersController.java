package com.nagarro.microfrontend.loanoffer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microfrontend.loanoffer.dto.ApiResponse;
import com.nagarro.microfrontend.loanoffer.service.LoanOfferService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/loanOffers")
@CrossOrigin
public class LoanOffersController {

	@Autowired
	private LoanOfferService loanOfferService;

	@GetMapping
	@ApiOperation(value = "Fetching Loan Offer Details", notes = "fetching Loan Offer Details")
	public ResponseEntity<ApiResponse> getLoanOfferDetails() {

		ApiResponse response = loanOfferService.getLoanOffers();

		return ResponseEntity.ok(response);
	}

}
