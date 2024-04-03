package com.nagarro.productservice.helper;

import java.util.List;

import com.nagarro.productservice.entity.ProductEntity;

public class TypeHelper<T> {

	T data;

	public TypeHelper(T data) {
		super();
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public String checkType() {

		if (data instanceof List<?>) {
			List<?> innerList = (List<?>) data;
			if (!innerList.isEmpty()) {
				Object firstElement = innerList.get(0);

				if (firstElement instanceof String) {
					return "ListOfProductNames";
				} else if (firstElement instanceof ProductEntity) {
					return "ListOfProductDetails";
				}
			}
		}
		return null;
	}
}
