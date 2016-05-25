package servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ServicioDireccion {
	@PersistenceContext
	private EntityManager em;
	
	
}
