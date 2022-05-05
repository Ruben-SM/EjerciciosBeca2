package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	ProductosDao productosDao;

	public ProductosServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}



	@Override
	public void alta(Producto p) {
		productosDao.save(p);
	}

	@Override
	public boolean baja(int id) {
		if(buscarPorId(id)!=null) {
			productosDao.deleteById(id);
			return true;
		}
		return false;
	}


	@Override
	public Producto buscarPorId(int id) {
		return productosDao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> buscarTodos() {
		return productosDao.findAll();
	}

	@Override
	public List<Producto> buscar(String seccion) {
		return productosDao.findBySeccion(seccion);
	}

}
