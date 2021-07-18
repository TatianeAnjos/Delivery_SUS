package com.tatiane.Delivery_SUS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.Delivery_SUS.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
