package com.simplilearn.webservice.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.model.Product;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	List<Product> productList = new LinkedList<Product>();
	
	// list all products
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productList;
	}
	
	// get one product
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") int id){
		for(Product product: productList) {
			if(product.getId()==id) {
				return product;
			}
		}
		return null;
	}
	
	// add product
	@PostMapping("/products")
	public List<Product> addProduct(@RequestBody Product product) {
		productList.add(product);
		return productList;
	}
	
	// update product
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		for(int index=0; index<productList.size(); index++) {
			if(product.getId()==productList.get(index).getId()) {
				productList.set(index, product);
				return product;
			}
		}
		return null;
	}
	
	// delete product
	@DeleteMapping("/products/{id}")
	public Product deleteProduct(@PathVariable("id") int id){
		for(int index=0; index<productList.size(); index++) {
			if(id==productList.get(index).getId()) {
				return productList.remove(index);
			}
		}
		return null;
	}
}
