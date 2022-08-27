package com.uce.edu.demo.modelo.sencillo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductoReporteDto extends ProductoVentaDto{
	
	private String categoria;
	
	private BigDecimal precioUnitario;
	
	private BigDecimal subTotal;



	public ProductoReporteDto(String codigoBarras, Integer cantidad, String categoria, BigDecimal precioUnitario,BigDecimal subTotal) {
		super(codigoBarras, cantidad);
		this.categoria = categoria;
		this.precioUnitario = precioUnitario;
		this.subTotal = subTotal;
		
	}


	//gey y set

	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}



	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	public BigDecimal getSubTotal() {
		return subTotal;
	}



	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	
	
	
	
	

}
