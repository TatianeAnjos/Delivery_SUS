package com.tatiane.Delivery_SUS.entities.Dto;

import java.util.List;

public class DadosBuscaEnderecoDto {

	private List<ResultadoBuscaEnderecoDto> results;
	private String status;
	
	public DadosBuscaEnderecoDto() {
		
	}
	public DadosBuscaEnderecoDto(List<ResultadoBuscaEnderecoDto> resultadoBuscaEnderecoDto, String status) {
		super();
		this.results = resultadoBuscaEnderecoDto;
		this.status = status;
	}
	public List<ResultadoBuscaEnderecoDto> getResultadoBuscaEnderecoDto() {
		return results;
	}
	public void setResultadoBuscaEnderecoDto(List<ResultadoBuscaEnderecoDto> resultadoBuscaEnderecoDto) {
		this.results = resultadoBuscaEnderecoDto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
