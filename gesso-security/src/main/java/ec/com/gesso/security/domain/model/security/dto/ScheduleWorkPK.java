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
public class ScheduleWorkPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_company")
    private long idCompany;
    @Basic(optional = false)
    @Column(name = "id_business_hour")
    private int idBusinessHour;

    public ScheduleWorkPK() {
    }

    public ScheduleWorkPK(long idCompany, int idBusinessHour) {
        this.idCompany = idCompany;
        this.idBusinessHour = idBusinessHour;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompany;
        hash += (int) idBusinessHour;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduleWorkPK)) {
            return false;
        }
        ScheduleWorkPK other = (ScheduleWorkPK) object;
        if (this.idCompany != other.idCompany) {
            return false;
        }
        if (this.idBusinessHour != other.idBusinessHour) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.ScheduleWorkPK[ idCompany=" + idCompany + ", idBusinessHour=" + idBusinessHour + " ]";
    }
    
}
