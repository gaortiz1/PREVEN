/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "phone")
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")})
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_phone")
    private Long idPhone;
    @Basic(optional = false)
    @Column(name = "numeber")
    private String numeber;
    @Basic(optional = false)
    @Column(name = "status_phone")
    private boolean statusPhone;
    @JoinColumn(name = "id_catalog_phone", referencedColumnName = "id_catalog")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalog catalog;
    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
    private Collection<ContactData> contactDataCollection;

    public Phone() {
    }

    public Phone(Long idPhone) {
        this.idPhone = idPhone;
    }

    public Phone(Long idPhone, String numeber, boolean statusPhone) {
        this.idPhone = idPhone;
        this.numeber = numeber;
        this.statusPhone = statusPhone;
    }

    public Long getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Long idPhone) {
        this.idPhone = idPhone;
    }

    public String getNumeber() {
        return numeber;
    }

    public void setNumeber(String numeber) {
        this.numeber = numeber;
    }

    public boolean getStatusPhone() {
        return statusPhone;
    }

    public void setStatusPhone(boolean statusPhone) {
        this.statusPhone = statusPhone;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Collection<ContactData> getContactDataCollection() {
        return contactDataCollection;
    }

    public void setContactDataCollection(Collection<ContactData> contactDataCollection) {
        this.contactDataCollection = contactDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhone != null ? idPhone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.idPhone == null && other.idPhone != null) || (this.idPhone != null && !this.idPhone.equals(other.idPhone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Phone[ idPhone=" + idPhone + " ]";
    }
    
}
