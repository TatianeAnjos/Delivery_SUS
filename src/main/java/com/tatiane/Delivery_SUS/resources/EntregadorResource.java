package com.tatiane.Delivery_SUS.resources;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/entregadores")
public class EntregadorResource {
	private final Logger log = LogManager.getLogger();
	
	@Autowired
	private EntregadorService service;
	
	@ApiOperation(value= "Retorna os Entregadores")
	@GetMapping
	public ResponseEntity<List<Entregador>> findAll(){
		log.info("|01| ENTREGADOR: BUSCAR TODOS");
		List<Entregador> lsEntregadores = service.findAll();
		return ResponseEntity.ok().body(lsEntregadores);
	}
	
	@ApiOperation(value= "Retorna os Entregadores por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entregador>findById(@PathVariable Long id){
		log.info("|01| ENTREGADOR: BUSCAR POR ID {} ", id);
		Entregador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value= "Cria um entregador")
	@PostMapping
	public ResponseEntity<Entregador> insert(@RequestBody EntregadorDto obj){
		log.info("|01| ENTREGADOR: CRIANDO ENTREGADOR {} ", obj);
		Entregador entregador= service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(entregador.getId()).toUri();
		
		return ResponseEntity.created(uri).body(entregador);
	}

}
