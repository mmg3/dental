package servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Ciudad;

@Stateless
public class ServicioCiudad {
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> listaCiudades()
	{
		List<Ciudad> ciudad; 
		
		String sql = "SELECt * FROM CIUDAD order by nombre";
		Query query = em.createNativeQuery(sql,Ciudad.class);
		
		ciudad = query.getResultList();
		
		return ciudad;
	}

}
