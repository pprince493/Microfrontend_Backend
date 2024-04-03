package com.nagarro.microfrontend.loanoffer.fakeDataProvider;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.microfrontend.loanoffer.entity.LoanOfferDetails;

public class FakeData {
	
	
	public static List<LoanOfferDetails> getPreDefinedLoanOffers(){
		List<LoanOfferDetails> offers=new ArrayList<>();
		offers.add(new LoanOfferDetails(1,100000,500000,"Bank Statement Required",10,12));
		offers.add(new LoanOfferDetails(2,500000,1000000,"Bank Statement , ITRV",10,12));
		offers.add(new LoanOfferDetails(3,1000000,2500000,"Bank Statement , GSTIN",10,12));
		offers.add(new LoanOfferDetails(4,2500000,5000000,"Balance Sheet Required",10,12));
		
		return offers;
		
	}

}
