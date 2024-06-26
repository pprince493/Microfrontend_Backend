package com.nagarro.productservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	private String productName;

	
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private List<ProductTypeEntity> productType;

	@Column(columnDefinition = "TINYINT(1)", nullable = false)
	private Boolean isActive;

}
