package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.sencillo.ProductoStockDto;
import com.uce.edu.demo.modelo.sencillo.ProductoVentaDto;
import com.uce.edu.demo.modelo.service.IProductoService;
import com.uce.edu.demo.modelo.service.IVentaService;


@SpringBootApplication
public class PruebaUnidad3CmApplication implements CommandLineRunner{

	private static Logger logger = Logger.getLogger(PruebaUnidad3CmApplication.class);

	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3CmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//1.Ingresar Productos:
		Producto pro1 = new Producto();
		pro1.setNombre("aaa");
		pro1.setCategoria("11A");
		pro1.setCodigoBarras("001");
		pro1.setPrecio(new BigDecimal(100));
		pro1.setStock(10);
		
		Producto pro2 = new Producto();
		pro2.setNombre("bbbb");
		pro2.setCategoria("22B");
		pro2.setCodigoBarras("002");
		pro2.setPrecio(new BigDecimal(50));
		pro2.setStock(15);
		
		Producto pro3 = new Producto();
		pro3.setNombre("ccc");
		pro3.setCategoria("22c");
		pro3.setCodigoBarras("003");
		pro3.setPrecio(new BigDecimal(60));
		pro3.setStock(11);
		
		this.productoService.ingresoPro(pro1);
		this.productoService.ingresoPro(pro2);
		this.productoService.ingresoPro(pro3);
		
		this.productoService.ingresoPro(pro1);
		this.productoService.ingresoPro(pro2);
		this.productoService.ingresoPro(pro3);
		
		
		//2.Realizar Venta:
		List<ProductoVentaDto> productoVenta = new ArrayList<>();
		ProductoVentaDto producto1 = new ProductoVentaDto("001", 30);
		ProductoVentaDto producto2 = new ProductoVentaDto("002", 19);
		ProductoVentaDto producto3 = new ProductoVentaDto("003", 20);
		productoVenta.add(producto1);
		productoVenta.add(producto2);
		productoVenta.add(producto3);
		
		
		this.ventaService.insertar("0000A", "0001", productoVenta);
		
		
		
		
		
		
		
		//4.Consultar Stock:
		ProductoStockDto  producto = this.productoService.bucarPorCodigoBarras("003");
		logger.info("producto: " );
		logger.info("codigo de barras " + producto.getCodigoBarras()+" nombre " + producto.getNombre()+ " stock " + producto.getStock() );
		
		
	}

}
