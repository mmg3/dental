package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TRATAMIENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Tratamiento.findAll", query="SELECT t FROM Tratamiento t")
public class Tratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idtratamiento;

	private String diagnostico;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String prescripcion;

	private String procedimiento;

	private BigDecimal sesion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="IDCONSULTA")
	private Consulta consulta;

	public Tratamiento() {
	}

	public long getIdtratamiento() {
		return this.idtratamiento;
	}

	public void setIdtratamiento(long idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPrescripcion() {
		return this.prescripcion;
	}

	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}

	public String getProcedimiento() {
		return this.procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public BigDecimal getSesion() {
		return this.sesion;
	}

	public void setSesion(BigDecimal sesion) {
		this.sesion = sesion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}