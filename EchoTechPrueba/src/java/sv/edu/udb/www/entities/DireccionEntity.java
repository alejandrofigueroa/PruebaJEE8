/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

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
@Table(name = "direcciones")
@NamedQueries({
    @NamedQuery(name = "DireccionEntity.findAll", query = "SELECT d FROM DireccionEntity d"),
    @NamedQuery(name = "DireccionEntity.findByIdDireccion", query = "SELECT d FROM DireccionEntity d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "DireccionEntity.findByPais", query = "SELECT d FROM DireccionEntity d WHERE d.pais = :pais"),
    @NamedQuery(name = "DireccionEntity.findByDepartamento", query = "SELECT d FROM DireccionEntity d WHERE d.departamento = :departamento"),
    @NamedQuery(name = "DireccionEntity.findByCiudad", query = "SELECT d FROM DireccionEntity d WHERE d.ciudad = :ciudad")})
public class DireccionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion")
    private Integer idDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String ciudad;
    @JoinColumn(name = "adicional_id", referencedColumnName = "id_adicional")
    @ManyToOne(optional = false)
    private AdicionalEntity adicionalId;

    public DireccionEntity() {
    }

    public DireccionEntity(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public DireccionEntity(Integer idDireccion, String pais, String departamento, String ciudad) {
        this.idDireccion = idDireccion;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public AdicionalEntity getAdicionalId() {
        return adicionalId;
    }

    public void setAdicionalId(AdicionalEntity adicionalId) {
        this.adicionalId = adicionalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionEntity)) {
            return false;
        }
        DireccionEntity other = (DireccionEntity) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.DireccionEntity[ idDireccion=" + idDireccion + " ]";
    }
    
}
