package model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pais {
	@JsonAlias(value = "name")
	String nombre;
	String capital;
	@JsonAlias(value = "region")
	String continente;
	@JsonAlias(value = "population")
	long poblacion;
	@JsonAlias(value = "flag")
	String bandera;

}
