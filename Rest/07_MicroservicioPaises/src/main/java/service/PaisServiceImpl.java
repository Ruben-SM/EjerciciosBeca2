package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pais;
@Service
public class PaisServiceImpl implements PaisService {
	
	RestTemplate template;
	String url="https://restcountries.com/v2/all";
	Pais[] paises;
	
	public PaisServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}

	@PostConstruct
	public void init(){
		paises= template.getForObject(url, Pais[].class);		
	}
	@Override
	public List<String> listaContinentes() {
		return Arrays.stream(paises)
		.map(p->p.getContinente())
		.distinct()
		.collect(Collectors.toList());
	}

	@Override
	public List<Pais> listaPaisesPorContinente(String continente) {
		return Arrays.stream(paises)
				.filter(p->p.getContinente().equals(continente))
				.collect(Collectors.toList());
	}
	@Override
	public Long habitantesContinente(String continente) {
		return Arrays.stream(paises)
				.filter(p->p.getContinente().equals(continente))
				.collect(Collectors.summingLong(p->p.getPoblacion()));
				
				
	}

	

}
