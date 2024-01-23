package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//@Component // Para indicar que a classe permite injeção de dependência para outras classes
@Service // Registra que é um serviço
public class UserService {
	
	@Autowired // Injeção de dependência
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); // Operação get retorna o User dentro do Optional
	}
	
	public User insert(User obj) { // Retorna o objeto salvo
		return repository.save(obj); // método save já salva o objeto no Banco de dados
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); // Deixa o objeto mapeado pelo banco de dados
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
