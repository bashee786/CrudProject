package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.service.CustomerServices;

@RestController
@RequestMapping("/api")
public class CustomerControl {

	@Autowired
	private CustomerServices customerService;

	@GetMapping("/get/customers")
	public List<CustomerDto> getProducts() {
		return customerService.getCustomers();
	}

	/**
	 * @implNote getting product by id
	 * @param id
	 * @return
	 */
	@GetMapping("/get/customer/by/id")
	public Customer getCustomerById(int id) {
		return customerService.getCustomerById(id);
	}
	
	/**
	 * @implNote
	 * @param id
	 * @return
	 */
	@GetMapping("/get/products/by/customer/{id}")
	public Product getProductsByCustomerId(@PathVariable int id) {
		return customerService.getProductsByCustomerId(id);
	}

	/**
	 * @implNote creating the products
	 * @param p
	 * @return
	 */

	@PostMapping(value = "/create/customers")
	public Customer createProducts(@RequestBody Customer p) {
		return customerService.createCustomer(p);
	}

	/**
	 * @implNote update the product by id
	 * @param id
	 * @param pt
	 * @return
	 */
	@PutMapping("/update/customer")
	public Customer updateProduct(int id, Customer pt) {
		return customerService.updateCustomer(id, pt);
	}

	/**
	 * @implNote deleting product by id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/customer")
	public int deleteProduct(int id) {
		return customerService.deleteCustomerById(id);
	}
}
