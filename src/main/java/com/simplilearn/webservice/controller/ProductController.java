package com.simplilearn.webservice.controller;

import java.util.LinkedList;
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

import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductNotFoundException;
import com.simplilearn.webservice.model.Product;
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	// list all products
	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> productList = productRepo.findAll();
		if (productList.isEmpty()) {
			throw new ProductNotFoundException("Product list is empty, 0 records found");
		}
		return productList;
	}

	// get one product
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		Product fetchedProduct = productRepo.findById(id).orElseThrow(() -> {
			throw new ProductNotFoundException("Product fetch failed, records not found with id " + id);
		});
		return fetchedProduct;
	}

	// add product
	@PostMapping("/products")
	public Product addProduct(@RequestBody(required = false) Product product) {
		if (product == null) {
			throw new InvalidProductException("Add product failed , Invalid request body");
		}
		return productRepo.save(product);
	}

	// update product
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		// step : find product
		Product fetchedProduct = productRepo.findById(id).orElseThrow(() -> {
			throw new ProductNotFoundException("Product fetch failed, records not found with id " + id);
		});
		// step 2: map product update fields
		fetchedProduct.setName(product.getName());
		fetchedProduct.setPrice(product.getPrice());
		fetchedProduct.setDescription(product.getDescription());
		return productRepo.save(fetchedProduct);
	}

	// delete product
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		// step : find product
		Product fetchedProduct = productRepo.findById(id).orElseThrow(() -> {
			throw new ProductNotFoundException("Product fetch failed, records not found with id " + id);
		});
		productRepo.delete(fetchedProduct);
		return "Product deleted successfully !";
	}
}
