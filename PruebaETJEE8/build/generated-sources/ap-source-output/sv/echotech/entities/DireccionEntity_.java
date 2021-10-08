package sv.echotech.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.echotech.entities.AdicionalEntity;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-08T10:44:36")
@StaticMetamodel(DireccionEntity.class)
public class DireccionEntity_ { 

    public static volatile SingularAttribute<DireccionEntity, AdicionalEntity> adicionalId;
    public static volatile SingularAttribute<DireccionEntity, Integer> idDireccion;
    public static volatile SingularAttribute<DireccionEntity, String> ciudad;
    public static volatile SingularAttribute<DireccionEntity, String> departamento;
    public static volatile SingularAttribute<DireccionEntity, String> pais;

}