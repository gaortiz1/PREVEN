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
public class ExperiencePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cv")
    private long idCv;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;
    @Basic(optional = false)
    @Column(name = "id_experience")
    private long idExperience;

    public ExperiencePK() {
    }

    public ExperiencePK(long idCv, long idPerson, long idExperience) {
        this.idCv = idCv;
        this.idPerson = idPerson;
        this.idExperience = idExperience;
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

    public long getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(long idExperience) {
        this.idExperience = idExperience;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCv;
        hash += (int) idPerson;
        hash += (int) idExperience;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperiencePK)) {
            return false;
        }
        ExperiencePK other = (ExperiencePK) object;
        if (this.idCv != other.idCv) {
            return false;
        }
        if (this.idPerson != other.idPerson) {
            return false;
        }
        if (this.idExperience != other.idExperience) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.ExperiencePK[ idCv=" + idCv + ", idPerson=" + idPerson + ", idExperience=" + idExperience + " ]";
    }
    
}
