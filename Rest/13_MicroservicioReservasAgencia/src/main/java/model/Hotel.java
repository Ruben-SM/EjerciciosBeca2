package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Hotel {

	private int idHotel;
	private String nombre;
	private int categoria;
	private double precio;
	private int disponible;
}
