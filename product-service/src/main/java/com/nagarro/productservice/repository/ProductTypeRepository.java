package com.nagarro.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.productservice.entity.ProductTypeEntity;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity,String> {

}
