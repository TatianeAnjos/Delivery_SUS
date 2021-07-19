package com.tatiane.Delivery_SUS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.Delivery_SUS.entities.Endereco;
import com.tatiane.Delivery_SUS.entities.User;
import com.tatiane.Delivery_SUS.entities.Dto.UserDto;
import com.tatiane.Delivery_SUS.entities.Mapper.EnderecoMapper;
import com.tatiane.Delivery_SUS.entities.Mapper.UserMapper;
import com.tatiane.Delivery_SUS.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoMapper enderecoMapper;

	@Autowired
	private UserMapper mapper;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	public User insert(UserDto obj) {
		User user = repository.save(mapper.mapear(obj));
		Endereco endereco = enderecoService.insert(enderecoMapper.mapear(obj,user));
		user.getEnderecos().add(endereco);
		return user;
	}

}
