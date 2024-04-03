package com.nagarro.postalservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
	
	private String id;
	
	private int statusCode;
	
	private String message;
	
	private Object data;
	

}
