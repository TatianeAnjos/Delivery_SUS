package com.tatiane.Delivery_SUS.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.Delivery_SUS.entities.Order;
import com.tatiane.Delivery_SUS.services.OrderService;

@RestController
@RequestMapping(value ="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> listOrders = service.findAll();
		return ResponseEntity.ok().body(listOrders);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
