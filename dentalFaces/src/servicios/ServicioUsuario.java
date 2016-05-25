package servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Usuario;

@Stateless
public class ServicioUsuario {
	@PersistenceContext
	private EntityManager em;
	
	public Usuario validarUsuario(Usuario usuario) {
		Usuario user;

		String sql = "SELECT * FROM USUARIO WHERE IDESTADO = 1 AND USERNAME = :userName AND CLAVE = :clave";
		/*String sql = "SELECT COD_USR , NOMBRE , APELLIDO , PASSWD , AREA , ESTADOS_ID , CONTRATANTE , EMAIL"
				+ "FROM MSHD_USUARIOS_VIEW";*/
		Query query = em.createNativeQuery(sql,Usuario.class);
		query.setParameter("userName", usuario.getUsername());
		query.setParameter("clave", usuario.getClave());
		
		System.out.println("Usuario: " + usuario.getUsername());
		System.out.println("Clave: " + usuario.getClave());
		
		try {
			user =  (Usuario) query.getSingleResult();
			System.out.println(user.getRolId());
			if(user.getIdusuarios() > 0) {
				return user;
			}
		}
		catch (Exception ex) {
			System.out.println("Error al logear: " + ex.getMessage());
			//nada, pasa a retornar 0
		}
		
		return null;
	}
	
}
