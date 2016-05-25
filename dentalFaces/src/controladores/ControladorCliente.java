package controladores;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import entidades.Cliente;
import servicios.ServicioCliente;
import servicios.subeArchivo;

@ViewScoped
@ManagedBean
public class ControladorCliente {
	
	@EJB
	private ServicioCliente srvCliente;
	
	private Cliente cliente;

	private subeArchivo archivoAdjunto;
	
	private int ciudadDireccion;
	
	
	public ControladorCliente()
	{
		cliente = new Cliente();
		//cliente.setFoto();
		archivoAdjunto = new subeArchivo();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCiudadDireccion() {
		return ciudadDireccion;
	}

	public void setCiudadDireccion(int ciudadDireccion) {
		this.ciudadDireccion = ciudadDireccion;
	}
	
	public void creaCliente() {
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("USUARIOID").toString());
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("USUARIO").toString());
		
		DateFormat fechaHora = new SimpleDateFormat("dd/mm/yyyy");
		
		BigDecimal usuarioEdita =  new BigDecimal(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("USUARIOID").toString());
		cliente.setIdusuarios(usuarioEdita);
		
		try {
			Date date;
			date = fechaHora.parse(FechaActual());
			cliente.setFechareg(date);
			
			if(cliente.getFoto() == null)
			{
				cliente.setFoto("avatarH.png");
			}
			
			srvCliente.actualizaCliente(cliente);
			
			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,	"Información","Cliente Guardado exitosamente!!!");
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
			
		} catch (ParseException e) {
			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,	"Información","El cliente que intenta guardar ya existe, por favor utilice el botón buscar.");
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
			
			System.out.println("Error al parsear fecha");
			return;
		}
		
		
	}
	
	public void buscaClientexHistoria() {
		
		try {
			if(cliente.getNhistoria().trim().length() > 0) {
				cliente = srvCliente.verificaClientexHistoria(cliente.getNhistoria());
				
			}
			else 
			{
				FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,	"Información","Ingrese un código de historia clinica.");
				FacesContext.getCurrentInstance().addMessage(null, mensaje);
				return;
			}
		}
		catch (Exception ex)
		{
			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,	"Información","Historia clinica no encontrada.");
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}
	}
	
public void buscaClientexIdentificacion() {
		
		try {
			if(cliente.getIdentificacion().trim().length() > 0) {
				cliente = srvCliente.verificaClientexIdentificacion(cliente.getIdentificacion());
			}
			else 
			{
				FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,	"Información","Ingrese una identificación del cliente.");
				FacesContext.getCurrentInstance().addMessage(null, mensaje);
				return;
			}
		}
		catch (Exception ex)
		{
			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,	"Información","Cliente no encontrado.");
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}
	}
	
	
	public void subirArchivo(FileUploadEvent evt) {

		// UploadedFile miArchivo; // aqui se va a guardar el archivo que
		// escogemos en el componente
		String extension = "";
		
		UploadedFile miArchivo = evt.getFile();
		long tamanio = miArchivo.getSize();// tamaño del archivo
		byte[] contenido = miArchivo.getContents();// contenido del archivo
		String tipoDeArchivo = miArchivo.getContentType();// que tipo de archivo
		String nombre = miArchivo.getFileName();
		
		extension = nombre.substring(nombre.lastIndexOf('.'));
		nombre = nombre.substring(0,nombre.lastIndexOf('.'));
		//nombre = nombre + FechaActualUnder();
		
		nombre = nombre.replaceAll("[^\\p{Alpha}\\p{Digit}]+", "_") + "_" + FechaActualUnder()+extension;
		
		System.out.println("-*****------- Tamaño: " + tamanio);
		System.out.println("-*****------- Contenido: " + contenido);
		System.out.println("-*****------- Tipo de Archivo: " + tipoDeArchivo);
		System.out.println("-*****------- Nombre: "+nombre);
		cliente.setFoto(nombre);
		archivoAdjunto.guardarFotoCliente(nombre, contenido);
		FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,	"Información","Foto guardada.");
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public String FechaActualUnder() {
		java.util.Date date = new java.util.Date();
		DateFormat fechaHora = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_mmm");
		String convertido = fechaHora.format(date);
		return convertido;
	}
	
	public String FechaActual() {
		java.util.Date date = new java.util.Date();
		DateFormat fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String convertido = fechaHora.format(date);
		return convertido;
	}
}