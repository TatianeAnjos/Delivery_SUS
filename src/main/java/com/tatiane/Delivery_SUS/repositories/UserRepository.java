package com.tatiane.Delivery_SUS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.Delivery_SUS.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
