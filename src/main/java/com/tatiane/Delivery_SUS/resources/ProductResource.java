package com.tatiane.Delivery_SUS.resources;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.Delivery_SUS.entities.Product;
import com.tatiane.Delivery_SUS.services.ProductService;


@RestController
@RequestMapping(value ="/products")
public class ProductResource {
	private final Logger log = LogManager.getLogger();

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		log.info("|01| PRODUTOS: BUSCAR TODOS");
		List<Product> listProducts = service.findAll();
		return ResponseEntity.ok().body(listProducts);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product>findById(@PathVariable Long id){
		log.info("|01| PRODUTOS: BUSCAR POR ID {} ", id);
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/buscarPorNome",method=RequestMethod.GET)
	public ResponseEntity<List<Product>>findByName(@RequestParam String name){
		log.info("|01| PRODUTOS: BUSCAR PRODUTO POR NOME {} ", name);
		List<Product> obj = service.buscarPorNome(name);
		return ResponseEntity.ok().body(obj);
	}


}
