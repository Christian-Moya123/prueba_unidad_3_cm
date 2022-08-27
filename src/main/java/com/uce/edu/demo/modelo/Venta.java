package com.uce.edu.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class Venta {

	@Id
	@Column(name="vent_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ven__name_gerneration")
	@SequenceGenerator(name = "ven__name_gerneration",sequenceName = "ven_t_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name="vent_numero")
	private String numero;
	
	@Column(name="vent_fecha")
	private LocalDateTime fecha;
	
	@Column(name="vent_cedula_cliente")
	private String cedulaCliente;
	
	@Column(name="vent_total_venta")
	private BigDecimal totalVenta;
	
	
	@OneToMany(mappedBy = "venta")
	private List<DetalleVenta> ventas;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public String getCedulaCliente() {
		return cedulaCliente;
	}


	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}


	public BigDecimal getTotalVenta() {
		return totalVenta;
	}


	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}


	public List<DetalleVenta> getVentas() {
		return ventas;
	}


	public void setVentas(List<DetalleVenta> ventas) {
		this.ventas = ventas;
	}
	
	
}
