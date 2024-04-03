package com.nagarro.postalservice.fakeDataProvider;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.postalservice.dto.ApiResponse;
import com.nagarro.postalservice.entity.PostalRecord;

public class FakeData {
	
	public static List<PostalRecord> getPreDefinedPostalsRecordForTesting(){
		List<PostalRecord> fakeData=new ArrayList<>();
		PostalRecord p=new PostalRecord(121004,"FARIDABAD","HARYANA", false,true);
		fakeData.add(p);
		return fakeData;
	}
	
	public static ApiResponse getPreDefinedApiResponseForTesting(){
		ApiResponse resp=new ApiResponse();
		PostalRecord p=new PostalRecord(121004,"FARIDABAD","HARYANA", false,true);
		resp.setStatusCode(200);
		resp.setMessage("Success");
		resp.setData(p);
		return resp;
	}

}
