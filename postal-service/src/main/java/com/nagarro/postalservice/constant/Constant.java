package com.nagarro.postalservice.constant;

public class Constant {
	
	public static final String FILE_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String SHEET = "Sheet2";
	public static final String FAIL_PARSING_FILE ="fail to parse Excel file: ";
	
	public static final String NEEDED_SIX_DIGIT_PINCODE="PINCODE MUST BE OF 6 DIGITS";

	public static final String FIND_POSTAL_RECORD="FIND POSTAL RECORD BY PINCODE";
	public static final String VERIFY_POSTAL_CODE="VERIFY IF POSTAL CODE IS BLACK LISTED";
	public static final String NOTE_FOR_GET_POSTAL_RECORD="it will return postal record of provided pincode if exist other wise it throw exception response";
	public static final String NOTE_FOR_VERIFY_POSTAL_CODE="it will return boolean response";
	public static final int HTTP_OK=200;
	public static final int HTTP_CREATED=201;
	
	public static final String RECORD_NOT_FOUND="RECORD NOT FOUND FOR PINCODE - ";
	
	public static final String CITY_NOT_IN_SERVICE="Sorry For Inconvenience , Rigth Now We Are Not Serving In Your City / District , Will Get Back To You Later when we Active Our Service To This Postal Code";
	
	public static final String RECORD_FOUND="SUCCESSFULLY FOUND RECORD FOR PINCODE ";
	}
