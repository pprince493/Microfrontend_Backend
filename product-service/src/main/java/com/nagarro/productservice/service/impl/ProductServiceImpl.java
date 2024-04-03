package com.nagarro.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.productservice.constant.Constant;
import com.nagarro.productservice.converter.Converter;
import com.nagarro.productservice.dto.ApiResponse;
import com.nagarro.productservice.dto.Product;
import com.nagarro.productservice.entity.ProductEntity;
import com.nagarro.productservice.exception.ProductNotFoundException;
import com.nagarro.productservice.helper.TypeHelper;
import com.nagarro.productservice.repository.ProductRepository;
import com.nagarro.productservice.service.ProductService;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Converter converter;

	public ApiResponse getProductDetailsByProductName(String productName) {

		ProductEntity productEntity = productRepository.getProductDetailsByProductName(productName);

		if (productEntity == null) {
			throw new ProductNotFoundException("NO PRODUCT WITH THIS NAME"+productName);
		}

		Product product=converter.convertToProductDto(productEntity);
		
		final ApiResponse response = new ApiResponse();
		response.setMessage("Success");
		response.setStatusCode(200);
		response.setData(product);

		return response;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ApiResponse getAllProducts(String filter) {
		TypeHelper h = null;
		List products = new ArrayList<>();
		final List allProducts;

		switch (filter.toLowerCase()) {

		case Constant.GET_PRODUCTS_NAMES:

			products = productRepository.getAllProductsNames();
			h = new TypeHelper<List<String>>(products);

			break;

		case Constant.GET_FULL_PRODUCTS_DETAILS:

			products = productRepository.findAll();
			h = new TypeHelper<List<ProductEntity>>(products);

			break;

		default:
			break;
		}

		if (products.isEmpty()) {
			throw new ProductNotFoundException("NO PRODUCTS AVAILABLE");
		}
		if (h.checkType() == "ListOfProductDetails") {
			allProducts = converter.convertToProductDtoList(products);
		} else {
			allProducts = products;
		}

		final ApiResponse response = new ApiResponse();
		response.setMessage("Success");
		response.setStatusCode(200);
		response.setData(allProducts);

		return response;
	}

}
