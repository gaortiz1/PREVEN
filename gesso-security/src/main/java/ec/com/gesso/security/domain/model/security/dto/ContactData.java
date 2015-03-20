/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "contact_data")
@NamedQueries({
    @NamedQuery(name = "ContactData.findAll", query = "SELECT c FROM ContactData c")})
public class ContactData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_contactdata")
    private Long idContactdata;
    @Column(name = "status_contactdata")
    private Boolean statusContactdata;
    @JoinColumn(name = "id_phone", referencedColumnName = "id_phone")
    @ManyToOne(fetch = FetchType.LAZY)
    private Phone phone;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
    @JoinColumn(name = "id_email", referencedColumnName = "id_email")
    @ManyToOne(fetch = FetchType.LAZY)
    private Email email;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    public ContactData() {
    }

    public ContactData(Long idContactdata) {
        this.idContactdata = idContactdata;
    }

    public Long getIdContactdata() {
        return idContactdata;
    }

    public void setIdContactdata(Long idContactdata) {
        this.idContactdata = idContactdata;
    }

    public Boolean getStatusContactdata() {
        return statusContactdata;
    }

    public void setStatusContactdata(Boolean statusContactdata) {
        this.statusContactdata = statusContactdata;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContactdata != null ? idContactdata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactData)) {
            return false;
        }
        ContactData other = (ContactData) object;
        if ((this.idContactdata == null && other.idContactdata != null) || (this.idContactdata != null && !this.idContactdata.equals(other.idContactdata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.ContactData[ idContactdata=" + idContactdata + " ]";
    }
    
}
