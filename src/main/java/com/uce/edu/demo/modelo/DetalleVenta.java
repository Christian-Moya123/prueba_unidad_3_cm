package com.uce.edu.demo.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DetalleVenta {
	
	@Id
	@Column(name="deva_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deva__name_gerneration")
	@SequenceGenerator(name = "deva__name_gerneration",sequenceName = "deva_t_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="deva_cantidad")
	private Integer cantidad;
	
	@Column(name="deva_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name="deva_sub_total")
	private BigDecimal subTotal;
	
	@ManyToOne
	@JoinColumn(name = "deva_id_venta")
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name = "deva_id_producto")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	

}
