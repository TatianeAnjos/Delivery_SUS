package com.tatiane.Delivery_SUS.entities.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tatiane.Delivery_SUS.entities.Order;
import com.tatiane.Delivery_SUS.entities.Dto.ItemResumoDto;
import com.tatiane.Delivery_SUS.entities.Dto.ResumoPedidoDto;

@Component
public class OrderMapper {

	public ResumoPedidoDto mapear(Order obj) {
		ResumoPedidoDto dto = new ResumoPedidoDto();

		dto.setNomeCliente(obj.getClient().getName());
		dto.setTelefoneCliente(obj.getClient().getPhone());

		dto.setIdPedido(obj.getId());
		dto.setStatus(obj.getOrderStatus());
		dto.setMomento(obj.getMoment());

		obj.getClient().getEnderecos().forEach(endereco -> {
			dto.setLogradouro(endereco.getLogradouro());
			dto.setNumero(endereco.getNumero());
			dto.setBairro(endereco.getBairro());
			dto.setCidade(endereco.getCidade());
		});

		if (!obj.getItems().isEmpty()) {
			obj.getItems().forEach(item -> {
				ItemResumoDto ir = new ItemResumoDto();
				ir.setNomeItem(item.getProduct().getName());
				ir.setQuantidade(item.getQuantidade());
				dto.getLsItemResumo().add(ir);
			});
		}
		return dto;
	}

	public List<ResumoPedidoDto> mapear(List<Order> orders) {
		List<ResumoPedidoDto> lsResumoPedido = new ArrayList<>();
		orders.parallelStream().forEach(order -> {
			lsResumoPedido.add(mapear(order));
		});
		return lsResumoPedido;
	}

}
