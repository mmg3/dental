package entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name="ROL")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDROL")
	private long idrol;
	
	@Column(name="NOMBRE")
	private String nombre;

	public Rol() {
	}

	public long getIdrol() {
		return this.idrol;
	}

	public void setIdrol(long idrol) {
		this.idrol = idrol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}