package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "CLIENTE_SEQ")
	@SequenceGenerator(sequenceName = "CLIENTE_SEQ", name = "CLIENTE_SEQ", initialValue= 1, allocationSize = 1000)
	@Column(name="IDCLIENTE")
	private long idcliente;

	@Column(name="APELLIDO")
	private String apellido;

	@Column(name="CIUDADNAC")
	private BigDecimal ciudadnac;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FECHANAC")
	private Date fechanac;

	@Column(name="FECHAREG")
	private Date fechareg;

	@Column(name="IDENTIFICACION")
	private String identificacion;

	@Column(name="IDUSUARIOS")
	private BigDecimal idusuarios;

	@Column(name="NHISTORIA")
	private String nhistoria;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TELEFONO1")
	private String telefono1;

	@Column(name="TELEFONO2")
	private String telefono2;

	@Column(name="TIPO1")
	private String tipo1;

	@Column(name="TIPO2")
	private String tipo2;
	
	@Column(name="FOTO")
	private String foto;
	
	@Column(name="GENERO")
	private String genero;
	
	@Column(name="DIRECCION")
	private String direccion;

	public Cliente() {
	}

	public long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public BigDecimal getCiudadnac() {
		return ciudadnac;
	}

	public void setCiudadnac(BigDecimal ciudadnac) {
		this.ciudadnac = ciudadnac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public Date getFechareg() {
		return fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public BigDecimal getIdusuarios() {
		return idusuarios;
	}

	public void setIdusuarios(BigDecimal idusuarios) {
		this.idusuarios = idusuarios;
	}

	public String getNhistoria() {
		return nhistoria;
	}

	public void setNhistoria(String nhistoria) {
		this.nhistoria = nhistoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTipo1() {
		return tipo1;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}