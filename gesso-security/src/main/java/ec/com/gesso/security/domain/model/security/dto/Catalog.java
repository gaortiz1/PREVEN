/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "catalog")
public class Catalog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_catalog")
    private Long idCatalog;
    @Basic(optional = false)
    @Column(name = "name_catalog")
    private String nameCatalog;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalog", fetch = FetchType.LAZY)
    @Transient
    private Collection<Person> personCollection;
    @JoinColumn(name = "id_groupcatalog", referencedColumnName = "id_groupcatalog")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupCatalog groupCatalog;

    public Catalog() {
    }

    public Catalog(Long idCatalog) {
        this.idCatalog = idCatalog;
    }

    public Catalog(Long idCatalog, String nameCatalog, boolean status) {
        this.idCatalog = idCatalog;
        this.nameCatalog = nameCatalog;
        this.status = status;
    }

    public Long getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Long idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getNameCatalog() {
        return nameCatalog;
    }

    public void setNameCatalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    public GroupCatalog getGroupCatalog() {
        return groupCatalog;
    }

    public void setGroupCatalog(GroupCatalog groupCatalog) {
        this.groupCatalog = groupCatalog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalog != null ? idCatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalog)) {
            return false;
        }
        Catalog other = (Catalog) object;
        if ((this.idCatalog == null && other.idCatalog != null) || (this.idCatalog != null && !this.idCatalog.equals(other.idCatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Catalog[ idCatalog=" + idCatalog + " ]";
    }
    
}
