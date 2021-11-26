package com.simplilearn.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
