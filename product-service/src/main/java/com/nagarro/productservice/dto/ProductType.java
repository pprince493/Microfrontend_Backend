package com.nagarro.productservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {

	private String productTypeName;

	private List<ProductSubCategory> subCategories;

	private Product product;
}
