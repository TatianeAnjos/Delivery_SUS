package com.tatiane.Delivery_SUS.entities.Dto;

public class GeometriaDto {

	private LocalizacaoDto location;
	private String location_type;
	private ViewportDto viewport;
	
	public GeometriaDto(LocalizacaoDto location, String location_type, ViewportDto viewport) {
		super();
		this.location = location;
		this.location_type = location_type;
		this.viewport = viewport;
	}
	public LocalizacaoDto getLocation() {
		return location;
	}
	public void setLocation(LocalizacaoDto location) {
		this.location = location;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public ViewportDto getViewport() {
		return viewport;
	}
	public void setViewport(ViewportDto viewport) {
		this.viewport = viewport;
	}
		
}
