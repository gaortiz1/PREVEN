/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "labor_contract")
@NamedQueries({
    @NamedQuery(name = "LaborContract.findAll", query = "SELECT l FROM LaborContract l")})
public class LaborContract implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LaborContractPK laborContractPK;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumns({
        @JoinColumn(name = "id_company", referencedColumnName = "id_company", insertable = false, updatable = false),
        @JoinColumn(name = "id_business_hour", referencedColumnName = "id_business_hour", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ScheduleWork scheduleWork;
    @JoinColumn(name = "id_job", referencedColumnName = "id_job", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Job job;
    @JoinColumns({
        @JoinColumn(name = "id_cv", referencedColumnName = "id_cv", insertable = false, updatable = false),
        @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CurriculumVitae curriculumVitae;

    public LaborContract() {
    }

    public LaborContract(LaborContractPK laborContractPK) {
        this.laborContractPK = laborContractPK;
    }

    public LaborContract(LaborContractPK laborContractPK, Date startDate) {
        this.laborContractPK = laborContractPK;
        this.startDate = startDate;
    }

    public LaborContract(long idCompany, int idBusinessHour, long idCv, long idPerson, long idJob) {
        this.laborContractPK = new LaborContractPK(idCompany, idBusinessHour, idCv, idPerson, idJob);
    }

    public LaborContractPK getLaborContractPK() {
        return laborContractPK;
    }

    public void setLaborContractPK(LaborContractPK laborContractPK) {
        this.laborContractPK = laborContractPK;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ScheduleWork getScheduleWork() {
        return scheduleWork;
    }

    public void setScheduleWork(ScheduleWork scheduleWork) {
        this.scheduleWork = scheduleWork;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public CurriculumVitae getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laborContractPK != null ? laborContractPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaborContract)) {
            return false;
        }
        LaborContract other = (LaborContract) object;
        if ((this.laborContractPK == null && other.laborContractPK != null) || (this.laborContractPK != null && !this.laborContractPK.equals(other.laborContractPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.LaborContract[ laborContractPK=" + laborContractPK + " ]";
    }
    
}
