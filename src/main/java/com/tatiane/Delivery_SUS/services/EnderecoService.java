package com.tatiane.Delivery_SUS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.Delivery_SUS.entities.Endereco;
import com.tatiane.Delivery_SUS.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.get();
	}
	
	public Endereco insert(Endereco endereco) {
		return repository.save(endereco);
	}
}
