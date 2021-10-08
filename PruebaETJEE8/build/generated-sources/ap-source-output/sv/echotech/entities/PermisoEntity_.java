package sv.echotech.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.echotech.entities.UsuarioEntity;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-08T10:44:36")
@StaticMetamodel(PermisoEntity.class)
public class PermisoEntity_ { 

    public static volatile SingularAttribute<PermisoEntity, Integer> eliminar;
    public static volatile SingularAttribute<PermisoEntity, Integer> idPermiso;
    public static volatile SingularAttribute<PermisoEntity, Integer> listar;
    public static volatile SingularAttribute<PermisoEntity, Integer> editar;
    public static volatile SingularAttribute<PermisoEntity, String> nombreSeccion;
    public static volatile SingularAttribute<PermisoEntity, UsuarioEntity> usuarioId;
    public static volatile SingularAttribute<PermisoEntity, Integer> crear;

}