package com.devsuperior.dscommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@GetMapping
	public String test() {
		return "Olá, Mundo!";
	}
	/**Postman:
	 * GET | http://localhost:8080/products
	 * 200 ok -> Olá, Mundo!
	 */
}
