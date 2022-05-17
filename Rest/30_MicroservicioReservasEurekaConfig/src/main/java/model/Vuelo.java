package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Vuelo {
	
	private int idvuelo;
	private String company;
	private String fecha;
	private double precio;
	private int plazas;
	
	
}