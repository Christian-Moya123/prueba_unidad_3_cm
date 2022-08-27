package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.sencillo.ProductoStockDto;


@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Producto ingresoPro(Producto producto) {
		// TODO Auto-generated method stub
		
		
		this.entityManager.persist(producto);
		return producto;
	}

	
	public ProductoStockDto bucarPorCodigoBarras(String codigo) {
		
		Query jpqlQuery = this.entityManager.createQuery("SELECT new com.uce.edu.demo.modelo.sencillo.ProductoStockDto(p.codigoBarras, p.nombre, p.stock, p.categoria) FROM Producto p where p.codigoBarras = :datoCodigo");
		jpqlQuery.setParameter("datoCodigo", codigo);
		
		return (ProductoStockDto) jpqlQuery.getSingleResult();	
		
	}

	@Override
	public Producto bucarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Producto p where p.codigoBarras = :datoCodigo");
		jpqlQuery.setParameter("datoCodigo", codigo);
		Producto result = null;
		
		try {
			 result =  (Producto) jpqlQuery.getSingleResult();	
		} catch (NoResultException notException) {
		
		}	
		return result;
	}
	
	

}
