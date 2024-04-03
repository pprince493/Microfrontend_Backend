package com.nagarro.postalservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostalRecord {
	
	@Id
	private long pinCode;
	
	private String district;
	
	private String state;
	
	private boolean isBlackListed=true;
	
	private boolean isActive=true;
	


}
