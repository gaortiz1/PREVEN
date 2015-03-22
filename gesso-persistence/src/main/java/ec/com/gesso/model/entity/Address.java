/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "address")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_address")
    private Long idAddress;
    @Basic(optional = false)
    @Column(name = "name_address")
    private String nameAddress;
    @Basic(optional = false)
    @Column(name = "status_address")
    private boolean statusAddress;
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Collection<ContactData> contactDataCollection;

    public Address() {
    }

    public Address(Long idAddress) {
        this.idAddress = idAddress;
    }

    public Address(Long idAddress, String nameAddress, boolean statusAddress) {
        this.idAddress = idAddress;
        this.nameAddress = nameAddress;
        this.statusAddress = statusAddress;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public boolean getStatusAddress() {
        return statusAddress;
    }

    public void setStatusAddress(boolean statusAddress) {
        this.statusAddress = statusAddress;
    }

    public Collection<ContactData> getContactDataCollection() {
        return contactDataCollection;
    }

    public void setContactDataCollection(Collection<ContactData> contactDataCollection) {
        this.contactDataCollection = contactDataCollection;
    }
    
}
