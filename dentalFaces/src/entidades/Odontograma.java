package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ODONTOGRAMA database table.
 * 
 */
@Entity
@NamedQuery(name="Odontograma.findAll", query="SELECT o FROM Odontograma o")
public class Odontograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idodontograma;

	private String nombre;

	private String valor;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="IDCONSULTA")
	private Consulta consulta;

	public Odontograma() {
	}

	public long getIdodontograma() {
		return this.idodontograma;
	}

	public void setIdodontograma(long idodontograma) {
		this.idodontograma = idodontograma;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}