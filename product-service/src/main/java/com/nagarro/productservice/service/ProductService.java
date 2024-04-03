package com.nagarro.productservice.service;

import com.nagarro.productservice.dto.ApiResponse;

public interface ProductService {
	
	ApiResponse getAllProducts(String filter);
	
	ApiResponse getProductDetailsByProductName(String productName);

}
