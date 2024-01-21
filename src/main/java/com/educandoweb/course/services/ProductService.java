package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//@Component // Para indicar que a classe permite injeção de dependência para outras classes
@Service // Registra que é um serviço
public class ProductService {
	
	@Autowired // Injeção de dependência
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get(); // Operação get retorna o Product dentro do Optional
	}

}
