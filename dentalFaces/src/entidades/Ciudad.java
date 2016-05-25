package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="CIUDAD")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDCIUDAD")
	private long idciudad;
	
	@Column(name="CODPOSTAL")
	private String codpostal;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="ORDEN")
	private BigDecimal orden;
	
	@Column(name="IDPROVINCIA")
	private int idProvincia;

	public Ciudad() {
	}

	public long getIdciudad() {
		return idciudad;
	}

	public void setIdciudad(long idciudad) {
		this.idciudad = idciudad;
	}

	public String getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}