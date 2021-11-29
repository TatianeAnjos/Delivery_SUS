package com.tatiane.Delivery_SUS.entities.Dto;

import org.springframework.stereotype.Component;

import com.tatiane.Delivery_SUS.entities.User;

@Component
public class VerificarLoginDto {

	private Boolean isLoginValido;
	private Long idUser;

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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

}
