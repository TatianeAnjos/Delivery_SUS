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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	private final Logger log = LogManager.getLogger();

	@Autowired
	private UserService service;
	
	@ApiOperation(value= "Retorna os Usuarios")
	@GetMapping
	public ResponseEntity<List<UserResumoDto>> findAll(){
		log.info("|01| USUARIO: BUSCAR TODOS");

		List<UserResumoDto> listUsers = service.findAll();
		return ResponseEntity.ok().body(listUsers);
	}
	@ApiOperation(value= "Retorna um  Usuario por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResumoDto>findById(@PathVariable Long id){
		log.info("|01| USUARIO: BUSCAR POR ID {} ", id);
		UserResumoDto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value= "Cria um Usuario")
	@PostMapping
	public ResponseEntity<UserResumoDto> insert(@RequestBody UserDto obj){
		log.info("|01| USUARIO: CRIAR USUARIO {} ", obj);
		UserResumoDto user = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}
	
	@ApiOperation(value= "Verifica o Login do Usuario")
	@GetMapping(value = "/verificarLogin")
	public ResponseEntity<VerificarLoginDto> verificarLogin(@RequestParam String email, @RequestParam String senha){
		log.info("|01| USUARIO: verificando login {} ", email);
		VerificarLoginDto dto = service.verificarLogin(email,senha);
		log.info("user: {} , login valido: {} ",dto.getIdUser(), dto.getIsLoginValido());
		return ResponseEntity.ok().body(dto);
	}
}
