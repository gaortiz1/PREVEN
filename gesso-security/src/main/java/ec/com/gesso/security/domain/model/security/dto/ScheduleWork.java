/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "schedule_work")
@NamedQueries({
    @NamedQuery(name = "ScheduleWork.findAll", query = "SELECT s FROM ScheduleWork s")})
public class ScheduleWork implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScheduleWorkPK scheduleWorkPK;
    @Basic(optional = false)
    @Column(name = "state_company_schedule_work")
    private boolean stateCompanyScheduleWork;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleWork", fetch = FetchType.LAZY)
    private Collection<LaborContract> laborContractCollection;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;
    @JoinColumn(name = "id_business_hour", referencedColumnName = "id_business_hour", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BusinessHour businessHour;

    public ScheduleWork() {
    }

    public ScheduleWork(ScheduleWorkPK scheduleWorkPK) {
        this.scheduleWorkPK = scheduleWorkPK;
    }

    public ScheduleWork(ScheduleWorkPK scheduleWorkPK, boolean stateCompanyScheduleWork) {
        this.scheduleWorkPK = scheduleWorkPK;
        this.stateCompanyScheduleWork = stateCompanyScheduleWork;
    }

    public ScheduleWork(long idCompany, int idBusinessHour) {
        this.scheduleWorkPK = new ScheduleWorkPK(idCompany, idBusinessHour);
    }

    public ScheduleWorkPK getScheduleWorkPK() {
        return scheduleWorkPK;
    }

    public void setScheduleWorkPK(ScheduleWorkPK scheduleWorkPK) {
        this.scheduleWorkPK = scheduleWorkPK;
    }

    public boolean getStateCompanyScheduleWork() {
        return stateCompanyScheduleWork;
    }

    public void setStateCompanyScheduleWork(boolean stateCompanyScheduleWork) {
        this.stateCompanyScheduleWork = stateCompanyScheduleWork;
    }

    public Collection<LaborContract> getLaborContractCollection() {
        return laborContractCollection;
    }

    public void setLaborContractCollection(Collection<LaborContract> laborContractCollection) {
        this.laborContractCollection = laborContractCollection;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BusinessHour getBusinessHour() {
        return businessHour;
    }

    public void setBusinessHour(BusinessHour businessHour) {
        this.businessHour = businessHour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleWorkPK != null ? scheduleWorkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduleWork)) {
            return false;
        }
        ScheduleWork other = (ScheduleWork) object;
        if ((this.scheduleWorkPK == null && other.scheduleWorkPK != null) || (this.scheduleWorkPK != null && !this.scheduleWorkPK.equals(other.scheduleWorkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.ScheduleWork[ scheduleWorkPK=" + scheduleWorkPK + " ]";
    }
    
}
