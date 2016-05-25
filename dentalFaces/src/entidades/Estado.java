package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Entity
@Table(name="ESTADO")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDESTADO")
	private long idestado;
	
	@Column(name="NOMBRE")
	private String nombre;

	public Estado() {
	}

	public long getIdestado() {
		return this.idestado;
	}

	public void setIdestado(long idestado) {
		this.idestado = idestado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}