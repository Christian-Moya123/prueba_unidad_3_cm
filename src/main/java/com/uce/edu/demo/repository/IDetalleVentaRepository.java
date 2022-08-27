package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.DetalleVenta;
import com.uce.edu.demo.modelo.Producto;

import com.uce.edu.demo.modelo.sencillo.ProductoReporteDto;


public interface IDetalleVentaRepository {
	public DetalleVenta ingreso(DetalleVenta detalleVentacto);
	public List<ProductoReporteDto> reporteProductoVendido();
	
	List<ProductoReporteDto> reporteVenta(LocalDateTime fecha, String categoria, Integer cantidad);
	
	
}
