package com.nagarro.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductSubCategoryEntity {
	
	@Id
	private String productSubCategoryName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productType")
	private ProductTypeEntity productType; 
	
	@Column(columnDefinition = "TINYINT(1)", nullable = false)
	private Boolean isActive;

}
