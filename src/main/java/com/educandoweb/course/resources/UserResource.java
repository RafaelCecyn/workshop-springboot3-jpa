package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

import jakarta.servlet.Servlet;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired // injeção de dependência
	private UserService service;

	@GetMapping // Requisição do tipo Get
	public ResponseEntity<List<User>> findAll() { // ResponseEntity retorno de requisições WEB
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "/{id}") // requisição com parâmetros
	public ResponseEntity<User> findById(@PathVariable Long id) {
		// PathVariable para associar o id da requisição com o id parâmetro
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		// @RequestBody para informar que o objeto inserido vem no formato Json
		obj = service.insert(obj);
		// Mudar a requisição para 201, forma adequada de retorno ao fazer inserção
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
