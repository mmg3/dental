package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TELEFONO database table.
 * 
 */
@Entity
@NamedQuery(name="Telefono.findAll", query="SELECT t FROM Telefono t")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idtelefono;

	private String numero;

	private String tipo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;

	public Telefono() {
	}

	public long getIdtelefono() {
		return this.idtelefono;
	}

	public void setIdtelefono(long idtelefono) {
		this.idtelefono = idtelefono;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}