package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//esto es un JavaBean 

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pagina {
	private String direccion;
	private String tematica;
	private String descripcion;
	
}
