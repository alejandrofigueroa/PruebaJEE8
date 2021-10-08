package sv.echotech.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.echotech.entities.UsuarioEntity;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-08T10:44:36")
@StaticMetamodel(RolEntity.class)
public class RolEntity_ { 

    public static volatile SingularAttribute<RolEntity, Integer> idRol;
    public static volatile SingularAttribute<RolEntity, String> nombreRol;
    public static volatile ListAttribute<RolEntity, UsuarioEntity> usuarioEntityList;

}