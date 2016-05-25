package entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="PROVINCIA")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	public long getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(long idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public long getPais() {
		return pais;
	}

	public void setPais(long pais) {
		this.pais = pais;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDPROVINCIA")
	private long idprovincia;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PREFIJO")
	private String prefijo;

	@Column(name="IDPAIS")
	private long pais;

	public Provincia() {
	}

}