/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echotech.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sv.echotech.entities.PermisoEntity;

/**
 *
 * @author al3ja
 */
@Stateless
public class PermisosModel {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaETJEE8PU");
    private EntityManager em;
    
    public List<PermisoEntity> listarRoles(){
        Query query = em.createNamedQuery("PermisoEntity.findAll");
        return query.getResultList();
    }
}
