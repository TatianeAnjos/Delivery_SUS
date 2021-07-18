package com.tatiane.Delivery_SUS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.Delivery_SUS.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
