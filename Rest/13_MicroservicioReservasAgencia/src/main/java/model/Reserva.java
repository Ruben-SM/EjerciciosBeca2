package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="reservas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreserva;
	private String nombre;
	private String dni;
	private int hotel;
	private int vuelo;
	
	public Reserva(String nombre, String dni, int hotel, int vuelo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
	}
	
	
	
	
}
