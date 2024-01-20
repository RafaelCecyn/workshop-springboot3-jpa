package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//@Component // Para indicar que a classe permite injeção de dependência para outras classes
@Service // Registra que é um serviço
public class OrderService {
	
	@Autowired // Injeção de dependência
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // Operação get retorna o Order dentro do Optional
	}

}
