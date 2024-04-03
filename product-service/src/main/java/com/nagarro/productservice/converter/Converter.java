package com.nagarro.productservice.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.productservice.dto.Product;
import com.nagarro.productservice.dto.ProductSubCategory;
import com.nagarro.productservice.dto.ProductType;
import com.nagarro.productservice.entity.ProductEntity;
import com.nagarro.productservice.entity.ProductSubCategoryEntity;
import com.nagarro.productservice.entity.ProductTypeEntity;

@Component
public class Converter {

	@Autowired
	private ModelMapper modelMapper;

	public List<Product> convertToProductDtoList(List<ProductEntity> productEntity) {
		List<Product> products = new ArrayList<Product>();
		productEntity.forEach(p -> products.add(convertToProductDto(p)));
		return products;
	}

	public Product convertToProductDto(ProductEntity productEntity) {
		List<ProductType> productTypes = new ArrayList<ProductType>();

		Product product = this.modelMapper.map(productEntity, Product.class);
		
		productEntity.getProductType().forEach(pt->productTypes.add(convertToProductTypeDto(pt)));
		
		product.setProductType(productTypes);

		return product;
	}

	public ProductType convertToProductTypeDto(ProductTypeEntity pte) {
		List<ProductSubCategory> categories=new ArrayList<ProductSubCategory>();
		
		ProductType productType=this.modelMapper.map(pte, ProductType.class);
		productType.setProduct(null);
		
		pte.getSubCategories().forEach(psc->categories.add(convertToProductSubCategoriesDto(psc)));
		
		productType.setSubCategories(categories);
		
		return productType;
	}
	
	public ProductSubCategory convertToProductSubCategoriesDto(ProductSubCategoryEntity pscEntity) {

		ProductSubCategory category = this.modelMapper.map(pscEntity, ProductSubCategory.class);
		category.setProductType(null);

		return category;
	}
	
	

}
