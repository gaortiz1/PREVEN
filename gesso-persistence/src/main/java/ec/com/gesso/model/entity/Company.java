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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Subcompany> subcompanyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company1", fetch = FetchType.LAZY)
    private Collection<Subcompany> subcompanyCollection1;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<ActivityEconomicCompany> activityEconomicCompanyCollection;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Document> documentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<ScheduleWork> scheduleWorkCollection;
    @JoinColumn(name = "id_typecompany", referencedColumnName = "id_typecompany")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeCompany typeCompany;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<ContactData> contactDataCollection;

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

    public Collection<Subcompany> getSubcompanyCollection() {
        return subcompanyCollection;
    }

    public void setSubcompanyCollection(Collection<Subcompany> subcompanyCollection) {
        this.subcompanyCollection = subcompanyCollection;
    }

    public Collection<Subcompany> getSubcompanyCollection1() {
        return subcompanyCollection1;
    }

    public void setSubcompanyCollection1(Collection<Subcompany> subcompanyCollection1) {
        this.subcompanyCollection1 = subcompanyCollection1;
    }

    public Collection<ActivityEconomicCompany> getActivityEconomicCompanyCollection() {
        return activityEconomicCompanyCollection;
    }

    public void setActivityEconomicCompanyCollection(Collection<ActivityEconomicCompany> activityEconomicCompanyCollection) {
        this.activityEconomicCompanyCollection = activityEconomicCompanyCollection;
    }

    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    public Collection<ScheduleWork> getScheduleWorkCollection() {
        return scheduleWorkCollection;
    }

    public void setScheduleWorkCollection(Collection<ScheduleWork> scheduleWorkCollection) {
        this.scheduleWorkCollection = scheduleWorkCollection;
    }

    public TypeCompany getTypeCompany() {
        return typeCompany;
    }

    public void setTypeCompany(TypeCompany typeCompany) {
        this.typeCompany = typeCompany;
    }

    public Collection<ContactData> getContactDataCollection() {
        return contactDataCollection;
    }

    public void setContactDataCollection(Collection<ContactData> contactDataCollection) {
        this.contactDataCollection = contactDataCollection;
    }
    
}
