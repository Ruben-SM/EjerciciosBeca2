package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="productos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Producto {
	@Id
	private int codigoProducto;
	private String producto;
	private double precioUnitario;
	private int stock;
}
