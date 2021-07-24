package com.tatiane.Delivery_SUS.entities.Dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.tatiane.Delivery_SUS.entities.enums.OrderStatus;

public class ResumoPedidoDto {

	private Long idPedido;
	private Instant momento;
	private OrderStatus status;
	
	private String nomeCliente;
	private String telefoneCliente;
	
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	
	private List<ItemResumoDto> lsItemResumo = new ArrayList<>();
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Instant getMomento() {
		return momento;
	}
	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public List<ItemResumoDto> getLsItemResumo() {
		return lsItemResumo;
	}
	public void setLsItemResumo(List<ItemResumoDto> lsItemResumo) {
		this.lsItemResumo = lsItemResumo;
	}
	
}
