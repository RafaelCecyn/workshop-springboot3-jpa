package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//@Component // Para indicar que a classe permite injeção de dependência para outras classes
@Service // Registra que é um serviço
public class CategoryService {
	
	@Autowired // Injeção de dependência
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get(); // Operação get retorna o Category dentro do Optional
	}

}
