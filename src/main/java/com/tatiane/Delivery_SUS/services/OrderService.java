package com.tatiane.Delivery_SUS.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tatiane.Delivery_SUS.entities.Order;
import com.tatiane.Delivery_SUS.entities.OrderItem;
import com.tatiane.Delivery_SUS.entities.enums.OrderStatus;
import com.tatiane.Delivery_SUS.repositories.OrderItemRepository;
import com.tatiane.Delivery_SUS.repositories.OrderRepository;
import com.tatiane.Delivery_SUS.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private UserService userService;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	@Transactional
	public Order insert(@Valid Order obj) {
		obj.setMoment(Instant.now());
		obj.setOrderStatus(OrderStatus.WAITING_PAYMENT);
		obj.setClient(userService.findById(obj.getClient().getId()));
		repository.save(obj);
		for (OrderItem item : obj.getItems()) {
			item.setProduct(productService.findById(item.getProduct().getId()));
			item.setOrder(obj);
			item.setQuantidade(item.getQuantidade());
		}
		orderItemRepository.saveAll(obj.getItems());
		return obj;
	}

}
