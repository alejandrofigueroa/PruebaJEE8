/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author al3ja
 */
@Entity
@Table(name = "adicionales")
@NamedQueries({
    @NamedQuery(name = "AdicionalEntity.findAll", query = "SELECT a FROM AdicionalEntity a"),
    @NamedQuery(name = "AdicionalEntity.findByIdAdicional", query = "SELECT a FROM AdicionalEntity a WHERE a.idAdicional = :idAdicional"),
    @NamedQuery(name = "AdicionalEntity.findByNombreUsuario", query = "SELECT a FROM AdicionalEntity a WHERE a.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "AdicionalEntity.findByApellidoUsuario", query = "SELECT a FROM AdicionalEntity a WHERE a.apellidoUsuario = :apellidoUsuario"),
    @NamedQuery(name = "AdicionalEntity.findByDocumentoIdentidad", query = "SELECT a FROM AdicionalEntity a WHERE a.documentoIdentidad = :documentoIdentidad"),
    @NamedQuery(name = "AdicionalEntity.findByTelefono", query = "SELECT a FROM AdicionalEntity a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "AdicionalEntity.findByFechaNacimiento", query = "SELECT a FROM AdicionalEntity a WHERE a.fechaNacimiento = :fechaNacimiento")})
public class AdicionalEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adicional")
    private Integer idAdicional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "documento_identidad")
    private String documentoIdentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioEntity usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adicionalId")
    private List<DireccionEntity> direccionEntityList;

    public AdicionalEntity() {
    }

    public AdicionalEntity(Integer idAdicional) {
        this.idAdicional = idAdicional;
    }

    public AdicionalEntity(Integer idAdicional, String nombreUsuario, String apellidoUsuario, String documentoIdentidad, String telefono, Date fechaNacimiento) {
        this.idAdicional = idAdicional;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdAdicional() {
        return idAdicional;
    }

    public void setIdAdicional(Integer idAdicional) {
        this.idAdicional = idAdicional;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public UsuarioEntity getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioEntity usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<DireccionEntity> getDireccionEntityList() {
        return direccionEntityList;
    }

    public void setDireccionEntityList(List<DireccionEntity> direccionEntityList) {
        this.direccionEntityList = direccionEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdicional != null ? idAdicional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdicionalEntity)) {
            return false;
        }
        AdicionalEntity other = (AdicionalEntity) object;
        if ((this.idAdicional == null && other.idAdicional != null) || (this.idAdicional != null && !this.idAdicional.equals(other.idAdicional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.AdicionalEntity[ idAdicional=" + idAdicional + " ]";
    }
    
}
