/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roberto
 */
@Embeddable
public class SubcompanyPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_company")
    private long idCompany;
    @Basic(optional = false)
    @Column(name = "id_subcompany")
    private long idSubcompany;

    public SubcompanyPK() {
    }

    public SubcompanyPK(long idCompany, long idSubcompany) {
        this.idCompany = idCompany;
        this.idSubcompany = idSubcompany;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public long getIdSubcompany() {
        return idSubcompany;
    }

    public void setIdSubcompany(long idSubcompany) {
        this.idSubcompany = idSubcompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompany;
        hash += (int) idSubcompany;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubcompanyPK)) {
            return false;
        }
        SubcompanyPK other = (SubcompanyPK) object;
        if (this.idCompany != other.idCompany) {
            return false;
        }
        if (this.idSubcompany != other.idSubcompany) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.SubcompanyPK[ idCompany=" + idCompany + ", idSubcompany=" + idSubcompany + " ]";
    }
    
}
