package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CONSULTA database table.
 * 
 */
@Entity
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idconsulta;

	private String enfermedad;

	@Temporal(TemporalType.DATE)
	private Date fechareg;

	private BigDecimal idhistoria;

	private String motivo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Odontograma
	@OneToMany(mappedBy="consulta")
	private List<Odontograma> odontogramas;

	//bi-directional many-to-one association to Tratamiento
	@OneToMany(mappedBy="consulta")
	private List<Tratamiento> tratamientos;

	public Consulta() {
	}

	public long getIdconsulta() {
		return this.idconsulta;
	}

	public void setIdconsulta(long idconsulta) {
		this.idconsulta = idconsulta;
	}

	public String getEnfermedad() {
		return this.enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Date getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public BigDecimal getIdhistoria() {
		return this.idhistoria;
	}

	public void setIdhistoria(BigDecimal idhistoria) {
		this.idhistoria = idhistoria;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Odontograma> getOdontogramas() {
		return this.odontogramas;
	}

	public void setOdontogramas(List<Odontograma> odontogramas) {
		this.odontogramas = odontogramas;
	}

	public Odontograma addOdontograma(Odontograma odontograma) {
		getOdontogramas().add(odontograma);
		odontograma.setConsulta(this);

		return odontograma;
	}

	public Odontograma removeOdontograma(Odontograma odontograma) {
		getOdontogramas().remove(odontograma);
		odontograma.setConsulta(null);

		return odontograma;
	}

	public List<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}

	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public Tratamiento addTratamiento(Tratamiento tratamiento) {
		getTratamientos().add(tratamiento);
		tratamiento.setConsulta(this);

		return tratamiento;
	}

	public Tratamiento removeTratamiento(Tratamiento tratamiento) {
		getTratamientos().remove(tratamiento);
		tratamiento.setConsulta(null);

		return tratamiento;
	}

}