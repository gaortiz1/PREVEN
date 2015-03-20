/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "subcompany")
@NamedQueries({
    @NamedQuery(name = "Subcompany.findAll", query = "SELECT s FROM Subcompany s")})
public class Subcompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubcompanyPK subcompanyPK;
    @Basic(optional = false)
    @Column(name = "status_subcompany")
    private boolean statusSubcompany;
    @JoinColumn(name = "id_subcompany", referencedColumnName = "id_company", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company1;

    public Subcompany() {
    }

    public Subcompany(SubcompanyPK subcompanyPK) {
        this.subcompanyPK = subcompanyPK;
    }

    public Subcompany(SubcompanyPK subcompanyPK, boolean statusSubcompany) {
        this.subcompanyPK = subcompanyPK;
        this.statusSubcompany = statusSubcompany;
    }

    public Subcompany(long idCompany, long idSubcompany) {
        this.subcompanyPK = new SubcompanyPK(idCompany, idSubcompany);
    }

    public SubcompanyPK getSubcompanyPK() {
        return subcompanyPK;
    }

    public void setSubcompanyPK(SubcompanyPK subcompanyPK) {
        this.subcompanyPK = subcompanyPK;
    }

    public boolean getStatusSubcompany() {
        return statusSubcompany;
    }

    public void setStatusSubcompany(boolean statusSubcompany) {
        this.statusSubcompany = statusSubcompany;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany1() {
        return company1;
    }

    public void setCompany1(Company company1) {
        this.company1 = company1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subcompanyPK != null ? subcompanyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcompany)) {
            return false;
        }
        Subcompany other = (Subcompany) object;
        if ((this.subcompanyPK == null && other.subcompanyPK != null) || (this.subcompanyPK != null && !this.subcompanyPK.equals(other.subcompanyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Subcompany[ subcompanyPK=" + subcompanyPK + " ]";
    }
    
}
