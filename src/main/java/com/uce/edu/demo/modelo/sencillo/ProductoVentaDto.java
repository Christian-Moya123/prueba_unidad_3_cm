package com.uce.edu.demo.modelo.sencillo;

public class ProductoVentaDto {
	
	private String codigoBarras;
	
	private Integer cantidad;
	
	

	public ProductoVentaDto() {
		super();
	}

	public ProductoVentaDto(String codigoBarras, Integer cantidad) {
		super();
		this.codigoBarras = codigoBarras;
		this.cantidad = cantidad;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
