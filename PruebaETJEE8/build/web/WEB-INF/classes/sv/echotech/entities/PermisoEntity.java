/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echotech.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author al3ja
 */
@Entity
@Table(name = "permisos")
@NamedQueries({
    @NamedQuery(name = "PermisoEntity.findAll", query = "SELECT p FROM PermisoEntity p"),
    @NamedQuery(name = "PermisoEntity.findByIdPermiso", query = "SELECT p FROM PermisoEntity p WHERE p.idPermiso = :idPermiso"),
    @NamedQuery(name = "PermisoEntity.findByNombreSeccion", query = "SELECT p FROM PermisoEntity p WHERE p.nombreSeccion = :nombreSeccion"),
    @NamedQuery(name = "PermisoEntity.findByListar", query = "SELECT p FROM PermisoEntity p WHERE p.listar = :listar"),
    @NamedQuery(name = "PermisoEntity.findByCrear", query = "SELECT p FROM PermisoEntity p WHERE p.crear = :crear"),
    @NamedQuery(name = "PermisoEntity.findByEditar", query = "SELECT p FROM PermisoEntity p WHERE p.editar = :editar"),
    @NamedQuery(name = "PermisoEntity.findByEliminar", query = "SELECT p FROM PermisoEntity p WHERE p.eliminar = :eliminar")})
public class PermisoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso")
    private Integer idPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_seccion")
    private String nombreSeccion;
    @Basic(optional = false)
    @NotNull
    private int listar;
    @Basic(optional = false)
    @NotNull
    private int crear;
    @Basic(optional = false)
    @NotNull
    private int editar;
    @Basic(optional = false)
    @NotNull
    private int eliminar;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioEntity usuarioId;

    public PermisoEntity() {
    }

    public PermisoEntity(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public PermisoEntity(Integer idPermiso, String nombreSeccion, int listar, int crear, int editar, int eliminar) {
        this.idPermiso = idPermiso;
        this.nombreSeccion = nombreSeccion;
        this.listar = listar;
        this.crear = crear;
        this.editar = editar;
        this.eliminar = eliminar;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public int getListar() {
        return listar;
    }

    public void setListar(int listar) {
        this.listar = listar;
    }

    public int getCrear() {
        return crear;
    }

    public void setCrear(int crear) {
        this.crear = crear;
    }

    public int getEditar() {
        return editar;
    }

    public void setEditar(int editar) {
        this.editar = editar;
    }

    public int getEliminar() {
        return eliminar;
    }

    public void setEliminar(int eliminar) {
        this.eliminar = eliminar;
    }

    public UsuarioEntity getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioEntity usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoEntity)) {
            return false;
        }
        PermisoEntity other = (PermisoEntity) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.echotech.entities.PermisoEntity[ idPermiso=" + idPermiso + " ]";
    }
    
}
