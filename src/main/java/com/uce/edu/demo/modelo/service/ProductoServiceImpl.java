package com.uce.edu.demo.modelo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.sencillo.ProductoStockDto;
import com.uce.edu.demo.repository.IProductoRepository;



@Service
@Transactional
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public Producto ingresoPro(Producto producto) {
		Producto pro = iProductoRepository.bucarPorCodigo(producto.getCodigoBarras());
		
		if(pro!=null) {
			pro.setStock(pro.getStock() + producto.getStock());
			return pro;
		}
		
		return this.iProductoRepository.ingresoPro(producto);
	}

	@Override
	public ProductoStockDto bucarPorCodigoBarras(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.bucarPorCodigoBarras(codigo);
	}

}
