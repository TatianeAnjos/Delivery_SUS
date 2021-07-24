package com.tatiane.Delivery_SUS.entities.Dto;

import javax.validation.constraints.NotNull;

public class ItemResumoDto {
	
	@NotNull
	private String nomeItem;
	
	@NotNull
	private Integer quantidade;
	
	
	public String getNomeItem() {
		return nomeItem;
	}
	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
