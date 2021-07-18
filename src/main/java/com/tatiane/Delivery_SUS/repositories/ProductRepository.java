package com.tatiane.Delivery_SUS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.Delivery_SUS.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
