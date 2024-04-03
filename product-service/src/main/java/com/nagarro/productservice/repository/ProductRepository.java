package com.nagarro.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.productservice.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	@Query("select i.productName from ProductEntity i")
	List<String> getAllProductsNames();

	@Query("from ProductEntity i where i.productName=?1")
	ProductEntity getProductDetailsByProductName(String productName);
}
