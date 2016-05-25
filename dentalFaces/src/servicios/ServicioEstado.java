package servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Estado;
import entidades.Usuario;

@Stateless
public class ServicioEstado {
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Estado> listaEstados() {
		String sql = "SELECT * FROM ESTADO";

		Query query = em.createNativeQuery(sql,Usuario.class);
		
		return query.getResultList();
	}
}
