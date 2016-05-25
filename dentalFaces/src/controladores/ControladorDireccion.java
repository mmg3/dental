package controladores;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Direccion;
import servicios.ServicioDireccion;

@ViewScoped
@ManagedBean
public class ControladorDireccion {
	@EJB
	private ServicioDireccion srvDireccion;
	
	private Direccion direccion;
	
	private List<Direccion> listDireccion;
	
	public ControladorDireccion()
	{
		direccion = new Direccion();
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Direccion> getListDireccion() {
		return listDireccion;
	}

	public void setListDireccion(List<Direccion> listDireccion) {
		this.listDireccion = listDireccion;
	}
}
