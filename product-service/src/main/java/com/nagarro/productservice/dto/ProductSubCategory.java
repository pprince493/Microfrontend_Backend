package com.nagarro.productservice.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductSubCategory {

	private String productSubCategoryName;

	private ProductType productType;
	
	private Boolean isActive;

}
