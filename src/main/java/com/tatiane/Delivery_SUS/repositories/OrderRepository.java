package com.tatiane.Delivery_SUS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tatiane.Delivery_SUS.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "select * from TB_ORDER where ORDER_STATUS = ? ORDER BY ID ASC", nativeQuery = true)
	List<Order> findByStatus(Integer status);

}
