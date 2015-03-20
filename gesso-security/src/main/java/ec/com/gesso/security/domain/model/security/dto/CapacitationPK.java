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
public class CapacitationPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cv")
    private long idCv;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;
    @Basic(optional = false)
    @Column(name = "id_capacitation")
    private int idCapacitation;

    public CapacitationPK() {
    }

    public CapacitationPK(long idCv, long idPerson, int idCapacitation) {
        this.idCv = idCv;
        this.idPerson = idPerson;
        this.idCapacitation = idCapacitation;
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

    public int getIdCapacitation() {
        return idCapacitation;
    }

    public void setIdCapacitation(int idCapacitation) {
        this.idCapacitation = idCapacitation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCv;
        hash += (int) idPerson;
        hash += (int) idCapacitation;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitationPK)) {
            return false;
        }
        CapacitationPK other = (CapacitationPK) object;
        if (this.idCv != other.idCv) {
            return false;
        }
        if (this.idPerson != other.idPerson) {
            return false;
        }
        if (this.idCapacitation != other.idCapacitation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.CapacitationPK[ idCv=" + idCv + ", idPerson=" + idPerson + ", idCapacitation=" + idCapacitation + " ]";
    }
    
}
