package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDUSUARIOS")
	private long idusuarios;
	
	@Column(name="APELLIDO")
	private String apellido;
	
	@Column(name="CLAVE")
	private String clave;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="USERNAME")
	private String username;

	@Column(name="IDESTADO")
	private int estado;

	@Column(name="IDROL")
	private int rolId;

	public Usuario() {
	}

	public long getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(long idusuarios) {
		this.idusuarios = idusuarios;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

}