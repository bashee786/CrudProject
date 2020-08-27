package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServices {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * @implNote getting the List of customers
	 * @author Basheera
	 * @return
	 */
	public List<CustomerDto> getCustomers() {

		// getting all the customers from db.

		List<Customer> custDetails = customerRepository.findAll();
		// seeting all the customers in to dto.
		List<CustomerDto> customersDto = new ArrayList<>();
		List<ProductDto> productDto = new ArrayList<>();
		custDetails.forEach(cust -> {
			CustomerDto c = new CustomerDto();
			List<Product> p = cust.getProducts();
			c.setName(cust.getName());
			c.setId(cust.getId());

			p.forEach(prd -> {
				ProductDto pd = new ProductDto();
				pd.setDate(prd.getDate());
				pd.setName(prd.getName());
				pd.setId(prd.getId());
				pd.setRate(prd.getRate());
				productDto.add(pd);
			});
			c.setProduct(productDto);
			customersDto.add(c);
		});
		return customersDto;

	}

	/**
	 * @implNote creating the customers
	 * @param p
	 * @return
	 */
	public Customer createCustomer(Customer p) {

		Customer pr = new Customer();

		pr.setName(p.getName());
		pr.setId(p.getId());
		pr = customerRepository.save(pr);
		return pr;

	}

	/**
	 * @implNote getting the customer details by product id
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(int id) {

		Optional<Customer> optionalProduct = customerRepository.findById(id);

		if (optionalProduct.isPresent()) {
			Customer details = optionalProduct.get();
			return details;
		}
		return null;

	}

	/**
	 * @implNote update the customer by id
	 * @param id
	 * @param pdc
	 * @return
	 */
	public Customer updateCustomer(int id, Customer pdc) {

		Optional<Customer> optionalProducts = customerRepository.findById(id);
		if (optionalProducts.isPresent()) {
			Customer product = optionalProducts.get();
			product.setName(pdc.getName());

			product = customerRepository.save(product);
			return product;
		}
		return null;

	}

	/**
	 * @implNote deleting the customer by id
	 * @param id
	 * @return
	 */
	public int deleteCustomerById(int id) {

		customerRepository.deleteById(id);
		return id;

	}

	public Product getProductsByCustomerId(int id) {

		Optional<Customer> optionalDetails = customerRepository.findById(id);
		Product p = new Product();
		if (optionalDetails.isPresent()) {

		}
		return null;
	}

}
