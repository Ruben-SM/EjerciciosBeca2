package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;

@Service
public class PedidosServiceImpl implements PedidosService {

	PedidosDao dao;
	RestTemplate template;
	
	String url="http://servicio-productos";


	public PedidosServiceImpl(@Autowired PedidosDao dao, @Autowired RestTemplate template){
		super();
		this.dao = dao;
		this.template = template;
	}

	@Override
	public boolean altaPedido(Pedido pedido) {
		ResponseEntity<String> response = template.exchange(url+"/producto/{codigoProducto}/{unidades}",
				HttpMethod.PUT,
				null,	
				String.class,
				pedido.getCodigoProducto(),pedido.getUnidades());
		
		String cuerpo = response.getBody();
			
		if (cuerpo.equals("true")) {
			dao.save(pedido);
			return true;
		}
		return false;
	}

	@Override
	public List<Pedido> listarPedidos() {
		return dao.findAll();
	}

}
