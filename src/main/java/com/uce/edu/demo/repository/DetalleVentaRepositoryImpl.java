package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.DetalleVenta;

import com.uce.edu.demo.modelo.sencillo.ProductoReporteDto;


@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DetalleVenta ingreso(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleVenta);
		return detalleVenta;
	}

	@Override
	public List<ProductoReporteDto> reporteProductoVendido() {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT com.uce.edu.demo.modelo.sencillo.ProductoReporteDto(d.producto.codigoBarras, d.producto.categoria, d.cantidad, d.precioUnitario, d.subTotal) FROM DetalleVenta d");
		
		return jpqlQuery.getResultList();
	}

	

	

	

}
