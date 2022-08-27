package com.uce.edu.demo.modelo.sencillo;

import javax.persistence.NamedNativeQuery;


public class ProductoStockDto {
	
	private String codigoBarras;
	private String nombre;
	private Integer stock;
	private String categoria;
	
	
	public ProductoStockDto() {
		super();
	}
	
	
	public ProductoStockDto(String codigoBarras, String nombre, Integer stock, String categoria) {
		super();
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.stock = stock;
		this.categoria = categoria;
	}


	//get y set
	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	

}
