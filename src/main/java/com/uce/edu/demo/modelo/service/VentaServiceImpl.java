package com.uce.edu.demo.modelo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import javax.transaction.Transactional;

import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uce.edu.demo.modelo.DetalleVenta;
import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.Venta;
import com.uce.edu.demo.modelo.sencillo.ProductoReporteDto;
import com.uce.edu.demo.modelo.sencillo.ProductoVentaDto;
import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;

@Service
@Transactional
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepository iVentaRepository;
	
	@Autowired
	private IDetalleVentaRepository tDetalleVentaRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	public Venta insertar(String cedula, String numero,  List<ProductoVentaDto> productos) {
		// TODO Auto-generated method stub
		Venta venta = new Venta();
		venta.setCedulaCliente(cedula);
		venta.setNumero(numero);
		venta.setFecha(LocalDateTime.now());
		
		Venta ventaGuardada = this.iVentaRepository.insertar(venta);
		BigDecimal total = new BigDecimal(0);
		
		
		for(ProductoVentaDto item : productos) {
			DetalleVenta detalle = new DetalleVenta();
			
			Producto producto = iProductoRepository.bucarPorCodigo(item.getCodigoBarras());
			Integer cantidad = 0;
			if(producto.getStock() <=0) {
				throw new RuntimeException(" Producto sin stock");
			}else {
				cantidad = Math.min(producto.getStock(), item.getCantidad());
			}
			
			BigDecimal subTotal	= producto.getPrecio().multiply(new BigDecimal(cantidad));
			detalle.setCantidad(cantidad);
			detalle.setPrecioUnitario(producto.getPrecio());
			detalle.setProducto(producto);
			detalle.setSubTotal(subTotal);
			detalle.setVenta(ventaGuardada);
	
			total = total.add(subTotal);
			this.tDetalleVentaRepository.ingreso(detalle);
			
			producto.setStock(producto.getStock()-cantidad);
		}
		
		ventaGuardada.setTotalVenta(total);	
		return ventaGuardada;
	}

	@Override
	public List<ProductoReporteDto> reporteProductoVendido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoReporteDto> reporteVenta(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		List<ProductoReporteDto> aux = this.tDetalleVentaRepository.reporteVenta(fecha, categoria, cantidad);
		return aux.stream().filter(item -> {
			return item.getCategoria().equals(categoria);
		
		}).map(item ->{
			return new ProductoReporteDto(item.getCodigoBarras(), 
					item.getCantidad(), 
					item.getCategoria(),
					item.getPrecioUnitario(),
					item.getSubTotal()
					);
					
		}).toList();
		
		
	}

	



	

}
