
package sv.echotech.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sv.echotech.entities.UsuarioEntity;
import sv.echotech.tools.PasswdEncrypt;


@Stateless
public class UsuariosModel {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaETJEE8PU");
    private EntityManager em;
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public UsuarioEntity verificarCredenciales(String usuario, String password) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("UsuarioEntity.login");
            //asignando valores a los parametros de la consulta nombrada
            query.setParameter("usuario", usuario);
            query.setParameter("password", PasswdEncrypt.encriptarSHA(password));
            return (UsuarioEntity) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<UsuarioEntity> listarUsuarios(){
        em = getEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNamedQuery("UsuarioEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarUsuarios(UsuarioEntity usuario){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.persist(usuario);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    public UsuarioEntity obtenerUsuario(int usuarioid){
        em = getEntityManager();
        em.getTransaction().begin();
        
        return em.find(UsuarioEntity.class, usuarioid);
    }
    
    
}
