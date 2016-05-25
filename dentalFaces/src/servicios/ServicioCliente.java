package servicios;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Cliente;

@Stateless
public class ServicioCliente {
	@PersistenceContext
	private EntityManager em;

	public void insertarCliente(Cliente clt) {
		System.out.println("Ingresa para guardar");
		em.persist(clt);
	}
	
	public void actualizaCliente(Cliente clt) {
		Cliente historia;
		Cliente ident;
		
		String direccionUrl;
		String[] urls;
		
		direccionUrl = serverIp();
		urls = direccionUrl.split("/");
		
		if(clt.getFoto().contains("http://"))
		{
			direccionUrl = "";
		}
		else
		{
			direccionUrl = "http://"+urls[1]+":8081/userFotos/";
		}
		
		historia = verificaClientexHistoria(clt.getNhistoria());
		if(historia.getApellido().trim().length() > 0)
		{
			historia.setApellido(clt.getApellido());
			historia.setCiudadnac(clt.getCiudadnac());
			historia.setEmail(clt.getEmail());
			historia.setFechanac(clt.getFechanac());
			historia.setFoto(direccionUrl + clt.getFoto());
			historia.setGenero(clt.getGenero());
			historia.setIdentificacion(clt.getIdentificacion());
			historia.setNombre(clt.getNombre());
			historia.setTelefono1(clt.getTelefono1());
			historia.setTelefono2(clt.getTelefono2());
			historia.setDireccion(clt.getDireccion());
			
			clt = historia;
		}
		else
		{
			ident = verificaClientexHistoria(clt.getNhistoria());
			if(ident.getApellido().trim().length() > 0)
			{
				ident.setApellido(clt.getApellido());
				ident.setCiudadnac(clt.getCiudadnac());
				ident.setEmail(clt.getEmail());
				ident.setFechanac(clt.getFechanac());
				ident.setFoto(direccionUrl + clt.getFoto());
				ident.setGenero(clt.getGenero());
				ident.setIdentificacion(clt.getIdentificacion());
				ident.setNombre(clt.getNombre());
				ident.setTelefono1(clt.getTelefono1());
				ident.setTelefono2(clt.getTelefono2());
				ident.setDireccion(clt.getDireccion());
				
				clt = ident;
			}
		}
		
		System.out.println("Ingresa para actualizar");
		em.merge(clt);
	}
	
	public Cliente verificaClientexHistoria(String historia) {
		Cliente retornoCliente;
		
		String sql = "select * from Cliente where NHISTORIA = :historia ";
		Query query = em.createNativeQuery(sql,Cliente.class);
		query.setParameter("historia", historia);
		
		retornoCliente = (Cliente) query.getSingleResult();
		
		return retornoCliente;
	}
	
	public Cliente verificaClientexIdentificacion(String identificacion) {
		Cliente retornoCliente;
		
		String sql = "select * from Cliente where identificacion = :identificacion";
		Query query = em.createNativeQuery(sql,Cliente.class);
		query.setParameter("identificacion", identificacion);
		
		retornoCliente = (Cliente) query.getSingleResult();
		
		return retornoCliente;
	}
	
	public String serverIp() {
		//InetAddress direccion = InetAddress.getLocalHost();
		String iplocal = "127.0.0.1";
		try {
			InetAddress address = InetAddress.getByName("localhost");
			address = InetAddress.getLocalHost();
			iplocal = address.toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return iplocal;
	}
}
