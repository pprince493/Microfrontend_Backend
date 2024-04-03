package com.nagarro.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.productservice.entity.ProductSubCategoryEntity;

@Repository
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategoryEntity,String> {

	
//	@Query("from ")
//	List<ProductSubCategoryEntity> getSubCategoriesByProductType(String productType);
}
