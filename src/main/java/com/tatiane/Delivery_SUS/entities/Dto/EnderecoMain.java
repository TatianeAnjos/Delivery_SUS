package com.tatiane.Delivery_SUS.entities.Dto;

public class EnderecoMain {
	
	private DadosBuscaEnderecoDto dadosBuscaEnderecoDto;

	public EnderecoMain() {
		
	}
	
	
	public EnderecoMain(DadosBuscaEnderecoDto dadosBuscaEnderecoDto) {
		super();
		this.dadosBuscaEnderecoDto = dadosBuscaEnderecoDto;
	}


	public DadosBuscaEnderecoDto getDadosBuscaEnderecoDto() {
		return dadosBuscaEnderecoDto;
	}

	public void setDadosBuscaEnderecoDto(DadosBuscaEnderecoDto dadosBuscaEnderecoDto) {
		this.dadosBuscaEnderecoDto = dadosBuscaEnderecoDto;
	}

}
