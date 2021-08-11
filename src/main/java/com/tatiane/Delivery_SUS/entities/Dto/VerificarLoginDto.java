package com.tatiane.Delivery_SUS.entities.Dto;

import org.springframework.stereotype.Component;

@Component
public class VerificarLoginDto {

	private Boolean isLoginValido;

	public VerificarLoginDto() {
		
	}
	
	public VerificarLoginDto(Boolean isLoginValido) {
		super();
		this.isLoginValido = isLoginValido;
	}

	public Boolean getIsLoginValido() {
		return isLoginValido;
	}

	public void setIsLoginValido(Boolean isLoginValido) {
		this.isLoginValido = isLoginValido;
	}
}
