package com.nagarro.userservice.constant;

public class Constant {

//  UserName
    public static final String NAME_REQUIRED_MESSAGE = "User Name is required";
    public static final String NAME_NOT_VALID_MESSAGE = "User Name Not Valid";
    public static final String NAME_PATTERN = "[a-zA-Z ]+";
    public static final String NAME_ERROR_MESSAGE = "Name must be between 4 and 50 characters";
    public static final int NAME_MIN_LENGTH = 4;
    public static final int NAME_MAX_LENGTH = 40;

//  Email
    public static final String EMAIL_REQUIRED_MESSAGE =  "Email is required";
    public static final String EMAIL_NOT_VALID_MESSAGE =  "Invalid email format Try example@example.com  !!" ;


//  Phone Numbers
    public static final String PHONE_NUMBER_PATTERN = "^[6-9]\\d{9}$";
    public static final String PHONE_NUMBER_ERROR_MESSAGE = "Phone number Not valid !! try with only 10 digit numbers starts with 9,8,7 or 6";
    public static final String PHONE_NUMBER_REQUIRED_MESSAGE = "Phone number is required";

//  Country Name
    public static final String COUNTRY_REQUIRED_MESSAGE = "Country Name Required";
    public static final String COUNTRY_PATTERN = "\\bIndia\\b";;
    public static final String COUNTRY_ERROR_MESSAGE = "Try Country \"India\" !!";


//  Country Code
    public static final String COUNTRY_CODE_PATTERN = "^[+][9][1]$";
    public static final String COUNTRY_CODE_ERROR_MESSAGE = "Try country code +91";
    public static final String COUNTRY_REQUIRED_ERROR_MESSAGE ="CountryCode is required";
    public static final  String USER_CREATED_SUCCESS_MESSAGE="Successfully Saved User!";
    public static final  String USER_CREATED_FAILED_MESSAGE= "An error occurred while creating the user";


    public static final  String ERROR_MESSAGES_DELIMETER= " & ";



}