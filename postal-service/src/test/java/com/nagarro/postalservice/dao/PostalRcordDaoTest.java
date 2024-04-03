package com.nagarro.postalservice.dao;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.postalservice.entity.PostalRecord;
import com.nagarro.postalservice.fakeDataProvider.FakeData;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Postal Rcords Dao Layer Testing")
public class PostalRcordDaoTest {
	
	@Autowired
	private PostalRecordDao dao;

	@Test
	@DisplayName("GET POSTAL RECORD BY PINCODE")
	void test() {
		PostalRecord postalRecordActual=dao.findByPinCode(121004);
		
		assertEquals(postalRecordActual,FakeData.getPreDefinedPostalsRecordForTesting().get(0));
	}
}
