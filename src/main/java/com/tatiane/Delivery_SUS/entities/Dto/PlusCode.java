package com.tatiane.Delivery_SUS.entities.Dto;

public class PlusCode {

	private String compound_code;
	private String global_code;
	
	public PlusCode(String codigoComposto, String codigoGlobal) {
		super();
		this.compound_code = codigoComposto;
		this.global_code = codigoGlobal;
	}
	
	public String getCodigoComposto() {
		return compound_code;
	}
	public void setCodigoComposto(String codigoComposto) {
		this.compound_code = codigoComposto;
	}
	public String getCodigoGlobal() {
		return global_code;
	}
	public void setCodigoGlobal(String codigoGlobal) {
		this.global_code = codigoGlobal;
	}
	
}
