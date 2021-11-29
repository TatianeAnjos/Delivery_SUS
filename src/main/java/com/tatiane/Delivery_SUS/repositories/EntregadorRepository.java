package com.tatiane.Delivery_SUS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tatiane.Delivery_SUS.entities.Entregador;


public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

	@Query(value = "select * from TB_ENTREGADOR where EMAIL = ?", nativeQuery = true)
	Entregador findByLoginE(String email);

}
