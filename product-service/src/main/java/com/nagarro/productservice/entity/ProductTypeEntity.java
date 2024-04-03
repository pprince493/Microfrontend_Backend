package com.nagarro.productservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductTypeEntity {

	@Id
	private String productTypeName;

	@OneToMany(mappedBy = "productType", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<ProductSubCategoryEntity> subCategories;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product")
	private ProductEntity product;

}
