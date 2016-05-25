package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="DIRECCION")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDDIRECCION")
	private long iddireccion;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="IDCIUDAD")
	private long idCiudad;

	@Column(name="IDCLIENTE")
	private long idCliente;

	public Direccion() {
	}

	public long getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(long iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	
}