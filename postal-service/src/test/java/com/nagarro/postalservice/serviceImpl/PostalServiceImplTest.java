package com.nagarro.postalservice.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nagarro.postalservice.converter.Converter;
import com.nagarro.postalservice.dao.PostalRecordDao;
import com.nagarro.postalservice.dto.ApiResponse;
import com.nagarro.postalservice.entity.PostalRecord;
import com.nagarro.postalservice.fakeDataProvider.FakeData;
import com.nagarro.postalservice.service.Impl.PostalServiceImpl;

@SpringBootTest
@DisplayName("CUSTOMER SERVICE IMPL TESTING")
@TestInstance(Lifecycle.PER_CLASS)
public class PostalServiceImplTest {
	
	
	@MockBean
	private PostalRecordDao postalDao;
	
	@Autowired
	private Converter converter;
	
	private PostalRecord postalRecord;
	
	@Autowired
	private PostalServiceImpl postalServiceImpl;
	
	@BeforeAll
	void setUp() throws Exception {
		postalRecord =FakeData.getPreDefinedPostalsRecordForTesting().get(0);
	}
	
	@Test
	@DisplayName("Get Postal Record By Postal Code")
	void testGetPostalRecordByPostalCode() {

		when(postalDao.findById(anyLong()))
		.thenReturn(Optional.of(postalRecord));
		
		ApiResponse actual = postalServiceImpl.getPostalRecordByPostalCode(postalRecord.getPinCode());

		verify(postalDao, times(1)).findById(anyLong());
		
		assertEquals(actual.getData(),converter.postalRecordEntityToPostalRecordDto(postalRecord));

	}
	
	@Test
	@DisplayName("Verify Black Listed Postal Record By Postal Code")
	void testVerifyPinCodeIsBlackListed() {

		when(postalDao.findById(anyLong()))
		.thenReturn(Optional.of(postalRecord));
		
		ApiResponse actual = postalServiceImpl.getPostalRecordByPostalCode(postalRecord.getPinCode());

		verify(postalDao, times(1)).findById(anyLong());
		
		assertEquals(actual.getData(),converter.postalRecordEntityToPostalRecordDto(postalRecord));

	}

}
