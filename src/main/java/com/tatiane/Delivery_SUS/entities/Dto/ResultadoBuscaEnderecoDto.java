package com.tatiane.Delivery_SUS.entities.Dto;

import java.util.List;

public class ResultadoBuscaEnderecoDto {
	
	private List<ComponentesEnderecoDto> address_components;
	private String formatted_address;
	private GeometriaDto geometry;
	private String place_id;
	private PlusCode plus_code;
	private List<String> types;
	
	
	public ResultadoBuscaEnderecoDto(List<ComponentesEnderecoDto> address_components, String formatted_address,
			GeometriaDto geometry, String place_id, PlusCode plus_code, List<String> types) {
		super();
		this.address_components = address_components;
		this.formatted_address = formatted_address;
		this.geometry = geometry;
		this.place_id = place_id;
		this.plus_code = plus_code;
		this.types = types;
	}
	
	public List<ComponentesEnderecoDto> getAddress_components() {
		return address_components;
	}
	public void setAddress_components(List<ComponentesEnderecoDto> address_components) {
		this.address_components = address_components;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public GeometriaDto getGeometry() {
		return geometry;
	}
	public void setGeometry(GeometriaDto geometry) {
		this.geometry = geometry;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public PlusCode getPlus_code() {
		return plus_code;
	}
	public void setPlus_code(PlusCode plus_code) {
		this.plus_code = plus_code;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	
}
