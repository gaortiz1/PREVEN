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
public class CurriculumVitaePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cv")
    private long idCv;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;

    public CurriculumVitaePK() {
    }

    public CurriculumVitaePK(long idCv, long idPerson) {
        this.idCv = idCv;
        this.idPerson = idPerson;
    }

    public long getIdCv() {
        return idCv;
    }

    public void setIdCv(long idCv) {
        this.idCv = idCv;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCv;
        hash += (int) idPerson;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurriculumVitaePK)) {
            return false;
        }
        CurriculumVitaePK other = (CurriculumVitaePK) object;
        if (this.idCv != other.idCv) {
            return false;
        }
        if (this.idPerson != other.idPerson) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.CurriculumVitaePK[ idCv=" + idCv + ", idPerson=" + idPerson + " ]";
    }
    
}
