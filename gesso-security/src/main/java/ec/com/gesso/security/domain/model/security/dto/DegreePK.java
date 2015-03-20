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
public class DegreePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_degree")
    private int idDegree;
    @Basic(optional = false)
    @Column(name = "id_leveleducation")
    private int idLeveleducation;

    public DegreePK() {
    }

    public DegreePK(int idDegree, int idLeveleducation) {
        this.idDegree = idDegree;
        this.idLeveleducation = idLeveleducation;
    }

    public int getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(int idDegree) {
        this.idDegree = idDegree;
    }

    public int getIdLeveleducation() {
        return idLeveleducation;
    }

    public void setIdLeveleducation(int idLeveleducation) {
        this.idLeveleducation = idLeveleducation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDegree;
        hash += (int) idLeveleducation;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DegreePK)) {
            return false;
        }
        DegreePK other = (DegreePK) object;
        if (this.idDegree != other.idDegree) {
            return false;
        }
        if (this.idLeveleducation != other.idLeveleducation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.DegreePK[ idDegree=" + idDegree + ", idLeveleducation=" + idLeveleducation + " ]";
    }
    
}
