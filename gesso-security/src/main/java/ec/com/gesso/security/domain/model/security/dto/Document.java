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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")})
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_type_docuement")
    private Integer idTypeDocuement;
    @Basic(optional = false)
    @Column(name = "value_document")
    private String valueDocument;
    @Basic(optional = false)
    @Column(name = "state_document")
    private boolean stateDocument;
    @JoinColumn(name = "id_type_docuement", referencedColumnName = "id_type_docuement", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private TypeDocument typeDocument;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    public Document() {
    }

    public Document(Integer idTypeDocuement) {
        this.idTypeDocuement = idTypeDocuement;
    }

    public Document(Integer idTypeDocuement, String valueDocument, boolean stateDocument) {
        this.idTypeDocuement = idTypeDocuement;
        this.valueDocument = valueDocument;
        this.stateDocument = stateDocument;
    }

    public Integer getIdTypeDocuement() {
        return idTypeDocuement;
    }

    public void setIdTypeDocuement(Integer idTypeDocuement) {
        this.idTypeDocuement = idTypeDocuement;
    }

    public String getValueDocument() {
        return valueDocument;
    }

    public void setValueDocument(String valueDocument) {
        this.valueDocument = valueDocument;
    }

    public boolean getStateDocument() {
        return stateDocument;
    }

    public void setStateDocument(boolean stateDocument) {
        this.stateDocument = stateDocument;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeDocuement != null ? idTypeDocuement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idTypeDocuement == null && other.idTypeDocuement != null) || (this.idTypeDocuement != null && !this.idTypeDocuement.equals(other.idTypeDocuement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Document[ idTypeDocuement=" + idTypeDocuement + " ]";
    }
    
}
