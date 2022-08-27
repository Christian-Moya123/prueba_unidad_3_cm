package com.uce.edu.demo.modelo.service;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.sencillo.ProductoStockDto;


public interface IProductoService {
	Producto ingresoPro(Producto producto);
	public ProductoStockDto bucarPorCodigoBarras(String codigo);
}
