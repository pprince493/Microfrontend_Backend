package com.nagarro.productservice.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Product {
	
	private long productId;
	
	private String productName;
	
	private List<ProductType> productType;
	
	private Boolean isActive;
	
	

}
