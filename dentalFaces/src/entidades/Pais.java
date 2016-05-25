package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="PAIS")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAIS_ID")
	private long paisId;

	@Column(name="PAIS_ISO2")
	private String paisIso2;

	@Column(name="PAIS_ISO3")
	private String paisIso3;

	@Column(name="PAIS_ISONUM")
	private BigDecimal paisIsonum;

	@Column(name="PAIS_NOMBRE")
	private String paisNombre;

	@Column(name="PAIS_ACTIVO")
	private Estado estado;


	public Pais() {
	}


	public long getPaisId() {
		return paisId;
	}


	public void setPaisId(long paisId) {
		this.paisId = paisId;
	}


	public String getPaisIso2() {
		return paisIso2;
	}


	public void setPaisIso2(String paisIso2) {
		this.paisIso2 = paisIso2;
	}


	public String getPaisIso3() {
		return paisIso3;
	}


	public void setPaisIso3(String paisIso3) {
		this.paisIso3 = paisIso3;
	}


	public BigDecimal getPaisIsonum() {
		return paisIsonum;
	}


	public void setPaisIsonum(BigDecimal paisIsonum) {
		this.paisIsonum = paisIsonum;
	}


	public String getPaisNombre() {
		return paisNombre;
	}


	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}