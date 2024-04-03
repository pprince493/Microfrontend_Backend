package com.nagarro.postalservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;

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
import com.nagarro.postalservice.dto.ApiResponse;
import com.nagarro.postalservice.fakeDataProvider.FakeData;
import com.nagarro.postalservice.service.PostalService;

@SpringBootTest
@DisplayName("ITEM CONTROLLER TESTING")
@TestInstance(Lifecycle.PER_CLASS)
public class PostalControllerTest {

	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@MockBean
	private PostalService postalService;
	
	private ApiResponse resp;
	
	@Autowired
	private ObjectMapper om;
	
	@BeforeAll
	private void setUp() throws ParseException {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}
	
	@Test
	@DisplayName("Get Postal Record By Postal Code")
	void testGetPostalRecordByPostalCode() throws Exception{
		
		long pincode=121004;
		
		String uri ="/postalRecords/"+ pincode;
		
		when(postalService.getPostalRecordByPostalCode(anyLong())).thenReturn(FakeData.getPreDefinedApiResponseForTesting());
	
		MvcResult result = mockMvc.perform(get(uri)).andExpect(status().isOk()).andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		
		ApiResponse response = om.readValue(resultContent, ApiResponse.class);
		
		assertEquals(response.getMessage(), FakeData.getPreDefinedApiResponseForTesting().getMessage());
	}
	
	@Test
	@DisplayName("Verify Postal Record Is Black Listed By Postal Code")
	void testVerifyPinCodeIsBlackListed() throws Exception{
		
		long pincode=121004;
		
		String uri ="/postalRecords/isBlackListed/"+ pincode;
		
		when(postalService.verifyPinCodeIsBlackListed(anyLong())).thenReturn(FakeData.getPreDefinedApiResponseForTesting());
	
		MvcResult result = mockMvc.perform(get(uri)).andExpect(status().isOk()).andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		
		ApiResponse response = om.readValue(resultContent, ApiResponse.class);
		
		assertEquals(response.getMessage(), FakeData.getPreDefinedApiResponseForTesting().getMessage());
	}
}
