package com.tatiane.Delivery_SUS.entities.Mapper;

import org.springframework.stereotype.Component;

import com.tatiane.Delivery_SUS.entities.Endereco;
import com.tatiane.Delivery_SUS.entities.User;
import com.tatiane.Delivery_SUS.entities.Dto.UserDto;

@Component
public class EnderecoMapper {

	public Endereco mapear(UserDto obj, User cliente) {
		Endereco endereco = new Endereco();
		endereco.setBairro(obj.getBairro());
		endereco.setCidade(obj.getCidade());
		endereco.setLogradouro(obj.getLogradouro());
		endereco.setNumero(obj.getNumero());
		endereco.setEstado(obj.getEstado());
		endereco.setCliente(cliente);
		return endereco;
	}
	
	
}
