package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {

	ProductosDao dao;
	
	public ProductosServiceImpl(@Autowired ProductosDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Producto> listaProductosExistentes() {
		return dao.findProductosDisponibles();
	}

	@Override
	public boolean actualizarStock(int codigoProducto, int unidades) {
		Producto p = dao.findById(codigoProducto).orElse(null);
		if (p != null) {
			int stock = p.getStock();
			if (stock >= unidades ) {
				p.setStock(stock-unidades);
				dao.save(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public double mostrarPrecio(int codigoProducto) {
		Producto p = dao.findById(codigoProducto).orElse(null);
		
		return (p!= null) ? p.getPrecioUnitario() : 0.0;
	}

}
