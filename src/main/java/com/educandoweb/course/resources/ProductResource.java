package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired // injeção de dependência
	private ProductService service;

	@GetMapping // Requisição do tipo Get
	public ResponseEntity<List<Product>> findAll() { // ResponseEntity retorno de requisições WEB
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "/{id}") // requisição com parâmetros
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		// PathVariable para associar o id da requisição com o id parâmetro
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
