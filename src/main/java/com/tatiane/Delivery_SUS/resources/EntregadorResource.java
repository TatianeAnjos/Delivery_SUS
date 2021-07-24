package com.tatiane.Delivery_SUS.resources;

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

import com.tatiane.Delivery_SUS.entities.Entregador;
import com.tatiane.Delivery_SUS.entities.Dto.EntregadorDto;
import com.tatiane.Delivery_SUS.services.EntregadorService;

@RestController
@RequestMapping(value ="/entregadores")
public class EntregadorResource {
	
	@Autowired
	private EntregadorService service;
	
	@GetMapping
	public ResponseEntity<List<Entregador>> findAll(){
		
		List<Entregador> lsEntregadores = service.findAll();
		return ResponseEntity.ok().body(lsEntregadores);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entregador>findById(@PathVariable Long id){
		Entregador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Entregador> insert(@RequestBody EntregadorDto obj){
		Entregador entregador= service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(entregador.getId()).toUri();
		
		return ResponseEntity.created(uri).body(entregador);
	}

}
