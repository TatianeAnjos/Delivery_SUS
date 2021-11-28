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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tatiane.Delivery_SUS.entities.Dto.UserDto;
import com.tatiane.Delivery_SUS.entities.Dto.UserResumoDto;
import com.tatiane.Delivery_SUS.entities.Dto.VerificarLoginDto;
import com.tatiane.Delivery_SUS.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	private final Logger log = LogManager.getLogger();

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserResumoDto>> findAll(){
		log.info("|01| USUARIO: BUSCAR TODOS");

		List<UserResumoDto> listUsers = service.findAll();
		return ResponseEntity.ok().body(listUsers);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResumoDto>findById(@PathVariable Long id){
		log.info("|01| USUARIO: BUSCAR POR ID {} ", id);
		UserResumoDto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<UserResumoDto> insert(@RequestBody UserDto obj){
		log.info("|01| USUARIO: CRIAR USUARIO {} ", obj);
		UserResumoDto user = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}
	
	@GetMapping(value = "/verificarLogin")
	public ResponseEntity<VerificarLoginDto> verificarLogin(@RequestParam String email, @RequestParam String senha){
		VerificarLoginDto dto = service.verificarLogin(email,senha);
		return ResponseEntity.ok().body(dto);
	}
}
