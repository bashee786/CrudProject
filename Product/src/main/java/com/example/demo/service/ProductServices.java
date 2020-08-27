package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * @implNote getting the List of products
	 * @author Basheera
	 * @return
	 */
	public List<Product> getProducts() {

		return productRepository.findAll();

	}

	/**
	 * @implNote creating the products
	 * @param p
	 * @return
	 */
	public Product createProduct(Product p) {

		Product pr = new Product();

		pr.setDate(p.getDate());
		pr.setName(p.getName());
		pr.setRate(p.getRate());
		pr = productRepository.save(pr);
		return pr;

	}

	/**
	 * @implNote getting the product details by product id
	 * @param id
	 * @return
	 */
	public Product getProductById(int id) {

		Optional<Product> optionalProduct = productRepository.findById(id);
		Product details = null;
		if (optionalProduct.isPresent()) {
			details = optionalProduct.get();
			return details;
		}

		return details;

	}

	/**
	 * @implNote update the products by id
	 * @param id
	 * @param pdc
	 * @return
	 */
	public Product updateProduct(int id, Product pdc) {

		Optional<Product> optionalProducts = productRepository.findById(id);
		if (optionalProducts.isPresent()) {
			Product product = optionalProducts.get();
			product.setDate(pdc.getDate());
			product.setName(pdc.getName());
			product.setRate(pdc.getRate());

			product = productRepository.save(product);
			return product;
		}
		return null;

	}

	/**
	 * @implNote deleting the product by id
	 * @param id
	 * @return
	 */
	public int deleteProductById(int id) {

		productRepository.deleteById(id);
		return id;

	}

}
