package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.sencillo.ProductoStockDto;


public interface IProductoRepository {
	 public Producto ingresoPro(Producto producto);
	 public ProductoStockDto bucarPorCodigoBarras(String codigo);
	 public Producto bucarPorCodigo(String codigo);
}
