/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "type_document")
@NamedQueries({
    @NamedQuery(name = "TypeDocument.findAll", query = "SELECT t FROM TypeDocument t")})
public class TypeDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_type_docuement")
    private Integer idTypeDocuement;
    @Basic(optional = false)
    @Column(name = "name_type_docuement")
    private String nameTypeDocuement;
    @Basic(optional = false)
    @Column(name = "state_type_docuement")
    private boolean stateTypeDocuement;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "typeDocument", fetch = FetchType.LAZY)
    private Document document;

    public TypeDocument() {
    }

    public TypeDocument(Integer idTypeDocuement) {
        this.idTypeDocuement = idTypeDocuement;
    }

    public TypeDocument(Integer idTypeDocuement, String nameTypeDocuement, boolean stateTypeDocuement) {
        this.idTypeDocuement = idTypeDocuement;
        this.nameTypeDocuement = nameTypeDocuement;
        this.stateTypeDocuement = stateTypeDocuement;
    }

    public Integer getIdTypeDocuement() {
        return idTypeDocuement;
    }

    public void setIdTypeDocuement(Integer idTypeDocuement) {
        this.idTypeDocuement = idTypeDocuement;
    }

    public String getNameTypeDocuement() {
        return nameTypeDocuement;
    }

    public void setNameTypeDocuement(String nameTypeDocuement) {
        this.nameTypeDocuement = nameTypeDocuement;
    }

    public boolean getStateTypeDocuement() {
        return stateTypeDocuement;
    }

    public void setStateTypeDocuement(boolean stateTypeDocuement) {
        this.stateTypeDocuement = stateTypeDocuement;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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
        if (!(object instanceof TypeDocument)) {
            return false;
        }
        TypeDocument other = (TypeDocument) object;
        if ((this.idTypeDocuement == null && other.idTypeDocuement != null) || (this.idTypeDocuement != null && !this.idTypeDocuement.equals(other.idTypeDocuement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.TypeDocument[ idTypeDocuement=" + idTypeDocuement + " ]";
    }
    
}
