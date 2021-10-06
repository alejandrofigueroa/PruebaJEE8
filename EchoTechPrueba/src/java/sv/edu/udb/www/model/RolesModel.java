
package sv.edu.udb.www.model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sv.edu.udb.www.entities.RolEntity;


@Stateless
public class RolesModel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchoTechPruebaPU");
    private EntityManager em;
    
    public List<RolEntity> listarRoles(){
        Query query = em.createNamedQuery("RolEntity.findAll");
        return query.getResultList();
    }

     
}
