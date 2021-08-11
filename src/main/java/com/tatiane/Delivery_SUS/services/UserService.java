package com.tatiane.Delivery_SUS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tatiane.Delivery_SUS.entities.Endereco;
import com.tatiane.Delivery_SUS.entities.User;
import com.tatiane.Delivery_SUS.entities.Dto.UserDto;
import com.tatiane.Delivery_SUS.entities.Dto.UserResumoDto;
import com.tatiane.Delivery_SUS.entities.Dto.VerificarLoginDto;
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
	
	public List<UserResumoDto> findAll(){
		return mapper.mapear(repository.findAll());
	}
	public UserResumoDto findById(Long id) {
		UserResumoDto obj = mapper.mapear(repository.findById(id).orElseThrow());
		return obj;
	}
	public UserResumoDto insert(UserDto obj) {
		User user = repository.save(mapper.mapear(obj));
		Endereco endereco = enderecoService.insert(enderecoMapper.mapear(obj,user));
		user.getEnderecos().add(endereco);
		return mapper.mapear(user);
	}
	public VerificarLoginDto verificarLogin(String email, String senha) {
		VerificarLoginDto dto = new VerificarLoginDto();
		User user = repository.findByLogin(email);
		if(user.getEmail().equals(email) && user.getPassword().equals(senha)) {
			dto.setIsLoginValido(true);
			return dto;
		}
		dto.setIsLoginValido(false);
		return dto;
	}

}
