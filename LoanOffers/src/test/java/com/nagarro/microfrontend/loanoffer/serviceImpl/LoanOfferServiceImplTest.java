package com.nagarro.microfrontend.loanoffer.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nagarro.microfrontend.loanoffer.dao.LoanOfferRepository;
import com.nagarro.microfrontend.loanoffer.dto.ApiResponse;
import com.nagarro.microfrontend.loanoffer.entity.LoanOfferDetails;
import com.nagarro.microfrontend.loanoffer.service.impl.LoanOfferServiceImpl;

@SpringBootTest
@DisplayName("LOAN OFFER SERVICE IMPL TESTING")
@TestInstance(Lifecycle.PER_CLASS)
public class LoanOfferServiceImplTest {

	
	@Autowired
	private LoanOfferServiceImpl loanOfferServiceImpl;
	
	@MockBean
	private LoanOfferRepository loanOfferRepository;
	
	private List<LoanOfferDetails> expectedOffers;
	
	@BeforeAll
	void setUp() throws Exception {
		expectedOffers =com.nagarro.microfrontend.loanoffer.fakeDataProvider.FakeData.getPreDefinedLoanOffers();
	}
	
	@Test
	@DisplayName("Get Loan Offers")
	void testGetLaonOffers() {
		ApiResponse expectedOffers=new ApiResponse();
		expectedOffers.setStatusCode(200);
		expectedOffers.setMessage("Success");
		expectedOffers.setData(this.expectedOffers);
		
		when(loanOfferRepository.findAll())
		.thenReturn(this.expectedOffers);
		
		ApiResponse actual = loanOfferServiceImpl.getLoanOffers();
		verify(loanOfferRepository, times(1)).findAll();
		
		assertEquals(actual,expectedOffers);

	}
}
