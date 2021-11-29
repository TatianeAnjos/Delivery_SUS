package com.tatiane.Delivery_SUS.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.Delivery_SUS.entities.Category;
import com.tatiane.Delivery_SUS.services.CategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@ApiOperation(value= "Retorna as Categorias")
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> listCategorys = service.findAll();
		return ResponseEntity.ok().body(listCategorys);
	}
	@ApiOperation(value= "Retorna as Categorias por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category>findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
