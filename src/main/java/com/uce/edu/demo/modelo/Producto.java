package com.uce.edu.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class Producto {
	
	@Id
	@Column(name="prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod__name_gerneration")
	@SequenceGenerator(name = "prod__name_gerneration",sequenceName = "prod_t_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="prod_codigo_barras")
	private String codigoBarras;
	
	@Column(name="prod_nombre")
	private String nombre;
	
	@Column(name="prod_categoria")
	private String categoria;
	
	@Column(name="prod_stock")
	private Integer stock;
	
	@Column(name="prod_precio")
	private BigDecimal precio;
	
	
	@OneToMany(mappedBy = "producto")
	private List<DetalleVenta> productos;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public List<DetalleVenta> getProductos() {
		return productos;
	}


	public void setProductos(List<DetalleVenta> productos) {
		this.productos = productos;
	}
	
	
	
	
	

}
