/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echotech.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author al3ja
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "UsuarioEntity.findAll", query = "SELECT u FROM UsuarioEntity u"),
    @NamedQuery(name = "UsuarioEntity.login", query = "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.password = :password"),
    @NamedQuery(name = "UsuarioEntity.findByIdUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioEntity.findByUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "UsuarioEntity.findByPassword", query = "SELECT u FROM UsuarioEntity u WHERE u.password = :password"),
    @NamedQuery(name = "UsuarioEntity.findByCorreoElectronico", query = "SELECT u FROM UsuarioEntity u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "UsuarioEntity.findByToken", query = "SELECT u FROM UsuarioEntity u WHERE u.token = :token"),
    @NamedQuery(name = "UsuarioEntity.findByVerificacion", query = "SELECT u FROM UsuarioEntity u WHERE u.verificacion = :verificacion")})
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String token;
    @Basic(optional = false)
    @NotNull
    private int verificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<AdicionalEntity> adicionalEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<PermisoEntity> permisoEntityList;
    @JoinColumn(name = "rol_id", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private RolEntity rolId;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioEntity(Integer idUsuario, String usuario, String password, String correoElectronico, String token, int verificacion) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.token = token;
        this.verificacion = verificacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(int verificacion) {
        this.verificacion = verificacion;
    }

    public List<AdicionalEntity> getAdicionalEntityList() {
        return adicionalEntityList;
    }

    public void setAdicionalEntityList(List<AdicionalEntity> adicionalEntityList) {
        this.adicionalEntityList = adicionalEntityList;
    }

    public List<PermisoEntity> getPermisoEntityList() {
        return permisoEntityList;
    }

    public void setPermisoEntityList(List<PermisoEntity> permisoEntityList) {
        this.permisoEntityList = permisoEntityList;
    }

    public RolEntity getRolId() {
        return rolId;
    }

    public void setRolId(RolEntity rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.echotech.entities.UsuarioEntity[ idUsuario=" + idUsuario + " ]";
    }
    
}
