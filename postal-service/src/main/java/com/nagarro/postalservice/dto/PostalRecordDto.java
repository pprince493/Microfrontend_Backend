package com.nagarro.postalservice.dto;

import javax.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostalRecordDto {

	@Digits(integer = 6, fraction = 0, message = "The value must be exactly 6 digits")
	private long pinCode;

	private String district;

	private String state;

	private boolean isBlackListed;
	
	private boolean isActive;
	
	public PostalRecordDto(boolean isBlackListed){
		this.isBlackListed=isBlackListed;
	}

}