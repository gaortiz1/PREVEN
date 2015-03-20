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
public class LaborContractPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_company")
    private long idCompany;
    @Basic(optional = false)
    @Column(name = "id_business_hour")
    private int idBusinessHour;
    @Basic(optional = false)
    @Column(name = "id_cv")
    private long idCv;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;
    @Basic(optional = false)
    @Column(name = "id_job")
    private long idJob;

    public LaborContractPK() {
    }

    public LaborContractPK(long idCompany, int idBusinessHour, long idCv, long idPerson, long idJob) {
        this.idCompany = idCompany;
        this.idBusinessHour = idBusinessHour;
        this.idCv = idCv;
        this.idPerson = idPerson;
        this.idJob = idJob;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdBusinessHour() {
        return idBusinessHour;
    }

    public void setIdBusinessHour(int idBusinessHour) {
        this.idBusinessHour = idBusinessHour;
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

    public long getIdJob() {
        return idJob;
    }

    public void setIdJob(long idJob) {
        this.idJob = idJob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompany;
        hash += (int) idBusinessHour;
        hash += (int) idCv;
        hash += (int) idPerson;
        hash += (int) idJob;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaborContractPK)) {
            return false;
        }
        LaborContractPK other = (LaborContractPK) object;
        if (this.idCompany != other.idCompany) {
            return false;
        }
        if (this.idBusinessHour != other.idBusinessHour) {
            return false;
        }
        if (this.idCv != other.idCv) {
            return false;
        }
        if (this.idPerson != other.idPerson) {
            return false;
        }
        if (this.idJob != other.idJob) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.LaborContractPK[ idCompany=" + idCompany + ", idBusinessHour=" + idBusinessHour + ", idCv=" + idCv + ", idPerson=" + idPerson + ", idJob=" + idJob + " ]";
    }
    
}
