package com.tatiane.Delivery_SUS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.Delivery_SUS.entities.Product;
import com.tatiane.Delivery_SUS.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}


}
