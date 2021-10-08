package sv.echotech.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.echotech.entities.DireccionEntity;
import sv.echotech.entities.UsuarioEntity;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-08T10:44:36")
@StaticMetamodel(AdicionalEntity.class)
public class AdicionalEntity_ { 

    public static volatile SingularAttribute<AdicionalEntity, String> documentoIdentidad;
    public static volatile SingularAttribute<AdicionalEntity, String> apellidoUsuario;
    public static volatile SingularAttribute<AdicionalEntity, Date> fechaNacimiento;
    public static volatile SingularAttribute<AdicionalEntity, Integer> idAdicional;
    public static volatile ListAttribute<AdicionalEntity, DireccionEntity> direccionEntityList;
    public static volatile SingularAttribute<AdicionalEntity, String> nombreUsuario;
    public static volatile SingularAttribute<AdicionalEntity, String> telefono;
    public static volatile SingularAttribute<AdicionalEntity, UsuarioEntity> usuarioId;

}