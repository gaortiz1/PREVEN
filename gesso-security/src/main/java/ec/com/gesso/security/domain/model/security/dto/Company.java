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
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_company")
    private Long idCompany;
    @Basic(optional = false)
    @Column(name = "name_company")
    private String nameCompany;
    @Basic(optional = false)
    @Column(name = "state_company")
    private boolean stateCompany;
    @JoinColumn(name = "id_typecompany", referencedColumnName = "id_typecompany")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeCompany typeCompany;

    public Company() {
    }

    public Company(Long idCompany) {
        this.idCompany = idCompany;
    }

    public Company(Long idCompany, String nameCompany, boolean stateCompany) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.stateCompany = stateCompany;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public boolean getStateCompany() {
        return stateCompany;
    }

    public void setStateCompany(boolean stateCompany) {
        this.stateCompany = stateCompany;
    }

    public TypeCompany getTypeCompany() {
        return typeCompany;
    }

    public void setTypeCompany(TypeCompany typeCompany) {
        this.typeCompany = typeCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompany != null ? idCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.idCompany == null && other.idCompany != null) || (this.idCompany != null && !this.idCompany.equals(other.idCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Company[ idCompany=" + idCompany + " ]";
    }
    
}
