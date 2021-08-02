package com.tatiane.Delivery_SUS.entities.Dto;

public class ViewportDto {

	private LocalizacaoDto northeast;
	private LocalizacaoDto southwest;
	public ViewportDto(LocalizacaoDto northeast, LocalizacaoDto southwest) {
		super();
		this.northeast = northeast;
		this.southwest = southwest;
	}
	public LocalizacaoDto getNortheast() {
		return northeast;
	}
	public void setNortheast(LocalizacaoDto northeast) {
		this.northeast = northeast;
	}
	public LocalizacaoDto getSouthwest() {
		return southwest;
	}
	public void setSouthwest(LocalizacaoDto southwest) {
		this.southwest = southwest;
	}
		
}
