
package sv.echotech.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sv.echotech.entities.RolEntity;


@Stateless
public class RolesModel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaETJEE8PU");
    private EntityManager em;
    
    public List<RolEntity> listarRoles(){
        Query query = em.createNamedQuery("RolEntity.findAll");
        return query.getResultList();
    }

     
}
