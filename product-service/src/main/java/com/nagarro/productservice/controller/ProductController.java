package com.nagarro.productservice.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productservice.dto.ApiResponse;
import com.nagarro.productservice.exception.RequstNotValidException;
import com.nagarro.productservice.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> getAllProducts(@RequestParam(defaultValue = "onlyGetProductsName") String filterBy){
		
		final ApiResponse response=this.productService.getAllProducts(filterBy);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{productName}")
	public ResponseEntity<ApiResponse> getAllProductName(@PathVariable String productName) {
		
		if(Objects.isNull(productName)) {
			throw new RequstNotValidException("Please Provide Vlaid Request");
		}
		
		ApiResponse resposne=productService.getProductDetailsByProductName(productName);
		
		return new ResponseEntity<ApiResponse>(resposne,HttpStatus.OK);
	}
	
}
