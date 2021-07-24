package com.tatiane.Delivery_SUS.entities.Mapper;

import org.springframework.stereotype.Component;

import com.tatiane.Delivery_SUS.entities.Entregador;
import com.tatiane.Delivery_SUS.entities.Dto.EntregadorDto;

@Component
public class EntregadorMapper {

	public Entregador mapear(EntregadorDto obj) {
		
		Entregador entidade = new Entregador();
		entidade.setName(obj.getName());
		entidade.setEmail(obj.getEmail());
		entidade.setPassword(obj.getPassword());
		entidade.setPhone(obj.getPhone());
		return entidade;
	}

}
