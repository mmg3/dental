package controladores;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entidades.Usuario;
import servicios.ServicioUsuario;

@ViewScoped
@ManagedBean
public class ControladorUsuario {
	@EJB
	private ServicioUsuario servUsuario;
	
	private Usuario user;
	private String nombreUsuario;
	private String claveUsuario; 
	
	
	public ControladorUsuario() {
		user = new Usuario();
	}
	
	
	public void cargar()
	{
		FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error identificación:", "Por favor, verifique sus datos de conexión.");
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		System.out.println("Cargando pag");
	}
	
	public void validaUsuario()
	{
		FacesContext contex = FacesContext.getCurrentInstance();
		user.setUsername(nombreUsuario);
		user.setClave(claveUsuario);
		
		try {
			/*if(user.getUsername() == null || user.getClave() == null)
			{
				System.out.println("No existe el usuario ingresado o los datos son erroneos");
				FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error identificación:", "Por favor, verifique sus datos de conexión.");
				contex.addMessage(null, mensaje);
			}
			else
			{*/
				Usuario valido = servUsuario.validarUsuario(user);
				//System.out.println("id de usuario: " + valido.getIdusuarios());
				if(valido.getIdusuarios() > 0)
				{
					System.out.println("***USUARIO:"+valido.getUsername().toUpperCase());
					System.out.println("usuario correcto");
					
					FacesMessage mensajebienv= new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido ", valido.getUsername());
					contex.addMessage(null, mensajebienv);
					contex.getExternalContext().getSessionMap().put("USUARIOID", valido.getIdusuarios());
					contex.getExternalContext().getSessionMap().put("USUARIO", valido.getUsername());
					
					System.out.println("rol: " + valido.getRolId());
					
					if(valido.getRolId() == 1)
					{
						System.out.println("redirecciona a maina");
			            contex.getExternalContext().redirect( "./maina.jsf" );
						//return "/maina.jsf";
					}
					else if(valido.getRolId() == 2)
					{
						contex.getExternalContext().redirect( "./mains.jsf" );
					}
					else
					{
						contex.getExternalContext().redirect( "./maino.jsf" );
					}
				}
				else {
					user=new Usuario();
					System.out.println("No existe el usuario ingresado o los datos son erroneos");
					FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error identificación:", "Por favor, verifique sus datos de conexión.");
					contex.addMessage(null, mensaje);
					contex.getExternalContext().redirect( "/index.jsf" );
				}
			//}
		}
		catch(Exception ex)
		{
			user=new Usuario();
			System.out.println("No existe el usuario ingresado o los datos son erroneos");
			FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error identificación:", "Por favor, verifique sus datos de conexión.");
			contex.addMessage(null, mensaje);
		}
	}
	
	public void logOut()
	{
		try {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
			FacesContext.getCurrentInstance().getExternalContext().redirect( "./" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

}
