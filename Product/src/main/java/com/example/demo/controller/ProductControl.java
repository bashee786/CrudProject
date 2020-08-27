package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductServices;

@RestController
@RequestMapping("/api")
public class ProductControl {

	@Autowired
	private ProductServices productServices;

	/**
	 * @implNote getting the products
	 * @return
	 */
	@GetMapping("/get/products")
	public List<Product> getProducts() {
		return productServices.getProducts();
	}

	/**
	 * @implNote getting product by id
	 * @param id
	 * @return
	 */
	@GetMapping("/get/product/by/{id}")
	public Product getProductById(@PathVariable int id) {
		return productServices.getProductById(id);
	}

	/**
	 * @implNote creating the products
	 * @param p
	 * @return
	 */

	@PostMapping("/create/products")
	public Product createProducts(Product p) {
		return productServices.createProduct(p);
	}

	/**
	 * @implNote update the product by id
	 * @param id
	 * @param pt
	 * @return
	 */
	@PutMapping("/update/product")
	public Product updateProduct(int id, Product pt) {
		return productServices.updateProduct(id, pt);
	}

	/**
	 * @implNote deleting product by id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/product")
	public int deleteProduct(int id) {
		return productServices.deleteProductById(id);
	}
}
