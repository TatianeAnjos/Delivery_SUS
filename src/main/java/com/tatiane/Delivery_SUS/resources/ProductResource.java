package com.tatiane.Delivery_SUS.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.Delivery_SUS.entities.Product;
import com.tatiane.Delivery_SUS.services.ProductService;


@RestController
@RequestMapping(value ="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> listProducts = service.findAll();
		return ResponseEntity.ok().body(listProducts);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product>findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}


}
