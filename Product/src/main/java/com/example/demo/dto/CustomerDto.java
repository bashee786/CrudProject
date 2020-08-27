package com.example.demo.dto;

import java.util.List;

public class CustomerDto {

	private int id;
	private String name;
	private List<ProductDto> product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDto> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDto> product) {
		this.product = product;
	}

}
