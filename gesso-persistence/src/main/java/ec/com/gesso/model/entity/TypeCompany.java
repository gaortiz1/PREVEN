/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "type_company")
@NamedQueries({
    @NamedQuery(name = "TypeCompany.findAll", query = "SELECT t FROM TypeCompany t")})
public class TypeCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_typecompany")
    private Integer idTypecompany;
    @Basic(optional = false)
    @Column(name = "name_typecompany")
    private String nameTypecompany;
    @Basic(optional = false)
    @Column(name = "status_typecompany")
    private boolean statusTypecompany;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeCompany", fetch = FetchType.LAZY)
    private Collection<Company> companyCollection;

    public TypeCompany() {
    }

    public TypeCompany(Integer idTypecompany) {
        this.idTypecompany = idTypecompany;
    }

    public TypeCompany(Integer idTypecompany, String nameTypecompany, boolean statusTypecompany) {
        this.idTypecompany = idTypecompany;
        this.nameTypecompany = nameTypecompany;
        this.statusTypecompany = statusTypecompany;
    }

    public Integer getIdTypecompany() {
        return idTypecompany;
    }

    public void setIdTypecompany(Integer idTypecompany) {
        this.idTypecompany = idTypecompany;
    }

    public String getNameTypecompany() {
        return nameTypecompany;
    }

    public void setNameTypecompany(String nameTypecompany) {
        this.nameTypecompany = nameTypecompany;
    }

    public boolean getStatusTypecompany() {
        return statusTypecompany;
    }

    public void setStatusTypecompany(boolean statusTypecompany) {
        this.statusTypecompany = statusTypecompany;
    }

    public Collection<Company> getCompanyCollection() {
        return companyCollection;
    }

    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
    }
}
