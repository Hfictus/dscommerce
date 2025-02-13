package com.devsuperior.dscommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	/**
	 * Postman : productbyid
	 * GET | http://localhost:8080/products/1
	 * 200 ok 
	 */
	
	@GetMapping
	public Page<ProductDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}
	/**
	 * Postman : products
	 * GET | http://localhost:8080/products
	 * ?size=12&page=0&sort=id,desc&name=pc gamer
	 * 200 ok 
	 */
}
