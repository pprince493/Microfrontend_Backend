package com.nagarro.microfrontend.loanoffer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.microfrontend.loanoffer.dto.ApiResponse;
import com.nagarro.microfrontend.loanoffer.entity.LoanOfferDetails;
import com.nagarro.microfrontend.loanoffer.service.LoanOfferService;

@SpringBootTest
@DisplayName("LOAN OFFER CONTROLLER TESTING")
@TestInstance(Lifecycle.PER_CLASS)
public class LoanOffersControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@Autowired
	private ObjectMapper om;

	@MockBean
	private LoanOfferService loanOfferService;

	@BeforeAll
	private void setUp() throws ParseException {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	@DisplayName("Get Loan Offers ")
	void testGetLoanOffrs() throws Exception {

		String uri = "/loanOffers";
		List<LoanOfferDetails> offers = com.nagarro.microfrontend.loanoffer.fakeDataProvider.FakeData
				.getPreDefinedLoanOffers();
		ApiResponse expected = new ApiResponse();
		expected.setStatusCode(200);
		expected.setMessage("Success");
		expected.setData(offers);

		when(loanOfferService.getLoanOffers()).thenReturn(expected);

		MvcResult result = mockMvc.perform(get(uri)).andExpect(status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();

		ApiResponse actual = om.readValue(resultContent, ApiResponse.class);

		assertEquals(actual.getMessage(), expected.getMessage());
	}

}
