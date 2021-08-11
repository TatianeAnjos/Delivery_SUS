package com.tatiane.Delivery_SUS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tatiane.Delivery_SUS.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from TB_USER where EMAIL = ?", nativeQuery = true)
	User findByLogin(String email);

}
