package com.uce.edu.demo.modelo.sencillo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductoReporteDto extends ProductoVentaDto{
	
	private LocalDateTime fecha;
	
	private String categoria;
	
	private Integer cantidad;

	
	
	public ProductoReporteDto(String categoria, LocalDateTime fecha,String codigoBarras, Integer cantidad, String nombre, BigDecimal precio, BigDecimal subtotal) {
		super();
		this.fecha = fecha;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}

	//gey y set
	public ProductoReporteDto() {
		super();
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
	

}
