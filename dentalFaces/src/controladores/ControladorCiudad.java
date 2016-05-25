package controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Ciudad;
import servicios.ServicioCiudad;

@ViewScoped
@ManagedBean
public class ControladorCiudad {
	
	@EJB
	private ServicioCiudad srvCiudad;
	
	private Ciudad ciudad;
	
	private List<Ciudad> listCiudad;

	public ControladorCiudad()
	{
		ciudad = new Ciudad();
	}
	
	@PostConstruct
	private void listaCiudades()
	{
		listCiudad = srvCiudad.listaCiudades();
	}

	public List<Ciudad> getListCiudad() {
		return listCiudad;
	}

	public void setListCiudad(List<Ciudad> listCiudad) {
		this.listCiudad = listCiudad;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}
