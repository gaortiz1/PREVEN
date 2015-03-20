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
public class DisabilityPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_disability")
    private long idDisability;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;

    public DisabilityPK() {
    }

    public DisabilityPK(long idDisability, long idPerson) {
        this.idDisability = idDisability;
        this.idPerson = idPerson;
    }

    public long getIdDisability() {
        return idDisability;
    }

    public void setIdDisability(long idDisability) {
        this.idDisability = idDisability;
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
        hash += (int) idDisability;
        hash += (int) idPerson;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisabilityPK)) {
            return false;
        }
        DisabilityPK other = (DisabilityPK) object;
        if (this.idDisability != other.idDisability) {
            return false;
        }
        if (this.idPerson != other.idPerson) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.DisabilityPK[ idDisability=" + idDisability + ", idPerson=" + idPerson + " ]";
    }
    
}
