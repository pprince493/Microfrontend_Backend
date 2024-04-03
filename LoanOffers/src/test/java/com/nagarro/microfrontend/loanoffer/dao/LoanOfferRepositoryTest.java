package com.nagarro.microfrontend.loanoffer.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.microfrontend.loanoffer.dao.LoanOfferRepository;
import com.nagarro.microfrontend.loanoffer.entity.LoanOfferDetails;
import com.nagarro.microfrontend.loanoffer.fakeDataProvider.FakeData;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Loan Offers Rcords Dao Layer Testing")
public class LoanOfferRepositoryTest {
	
	@Autowired
	private LoanOfferRepository dao;
	
	
	@Test
	@DisplayName("GET LOAN OFFERS")
	void testGetLoanOffers() {
		List<LoanOfferDetails>	actualOffers=dao.findAll();
		
		assertEquals(actualOffers,FakeData.getPreDefinedLoanOffers());
	}

}
