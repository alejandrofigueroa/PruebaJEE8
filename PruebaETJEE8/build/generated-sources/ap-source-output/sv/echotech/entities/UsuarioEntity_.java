package sv.echotech.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.echotech.entities.AdicionalEntity;
import sv.echotech.entities.PermisoEntity;
import sv.echotech.entities.RolEntity;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-08T10:44:36")
@StaticMetamodel(UsuarioEntity.class)
public class UsuarioEntity_ { 

    public static volatile SingularAttribute<UsuarioEntity, RolEntity> rolId;
    public static volatile SingularAttribute<UsuarioEntity, String> password;
    public static volatile SingularAttribute<UsuarioEntity, Integer> verificacion;
    public static volatile SingularAttribute<UsuarioEntity, Integer> idUsuario;
    public static volatile ListAttribute<UsuarioEntity, PermisoEntity> permisoEntityList;
    public static volatile SingularAttribute<UsuarioEntity, String> usuario;
    public static volatile SingularAttribute<UsuarioEntity, String> correoElectronico;
    public static volatile ListAttribute<UsuarioEntity, AdicionalEntity> adicionalEntityList;
    public static volatile SingularAttribute<UsuarioEntity, String> token;

}