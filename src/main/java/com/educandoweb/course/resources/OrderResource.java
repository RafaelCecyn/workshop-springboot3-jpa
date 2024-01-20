package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired // injeção de dependência
	private OrderService service;

	@GetMapping // Requisição do tipo Get
	public ResponseEntity<List<Order>> findAll() { // ResponseEntity retorno de requisições WEB
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "/{id}") // requisição com parâmetros
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		// PathVariable para associar o id da requisição com o id parâmetro
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
