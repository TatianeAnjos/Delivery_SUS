package com.tatiane.Delivery_SUS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.Delivery_SUS.entities.Entregador;
import com.tatiane.Delivery_SUS.entities.Dto.EntregadorDto;
import com.tatiane.Delivery_SUS.entities.Mapper.EntregadorMapper;
import com.tatiane.Delivery_SUS.repositories.EntregadorRepository;

@Service
public class EntregadorService {
	
	@Autowired
	private EntregadorRepository repository;
	
	@Autowired
	private EntregadorMapper mapper;
	
	public List<Entregador> findAll(){
		return repository.findAll();
	}
	public Entregador findById(Long id) {
		Optional<Entregador> obj = repository.findById(id);
		return obj.get();
	}
	public Entregador insert(EntregadorDto obj) {
		return repository.save(mapper.mapear(obj));
	}
}
