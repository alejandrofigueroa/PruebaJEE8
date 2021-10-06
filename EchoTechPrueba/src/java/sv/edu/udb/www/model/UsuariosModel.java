
package sv.edu.udb.www.model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.tools.PasswdEncrypt;


@Stateless
public class UsuariosModel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchoTechPruebaPU");
    private EntityManager em;

    
    public UsuarioEntity verificarCredenciales(String usuario, String password) {
        try {
            Query query = em.createNamedQuery("UsuarioEntity.Login");
            //asignando valores a los parametros de la consulta nombrada
            query.setParameter("usuario", usuario);
            query.setParameter("password", PasswdEncrypt.encriptarSHA(password));
            return (UsuarioEntity) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<UsuarioEntity> listarUsuarios(){
        Query query = em.createNamedQuery("UsuarioEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarUsuarios(UsuarioEntity usuario){
        try{
            em.persist(usuario);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    
}
