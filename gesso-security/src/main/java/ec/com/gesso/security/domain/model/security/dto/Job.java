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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "job")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")})
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_job")
    private Long idJob;
    @Basic(optional = false)
    @Column(name = "name_job")
    private String nameJob;
    @Basic(optional = false)
    @Column(name = "description_job")
    private String descriptionJob;
    @Basic(optional = false)
    @Column(name = "status_job")
    private boolean statusJob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    private Collection<LaborContract> laborContractCollection;
    @JoinColumn(name = "id_subprocess", referencedColumnName = "id_subprocess")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subprocess subprocess;
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private Collection<Job> jobCollection;
    @JoinColumn(name = "job_id_job", referencedColumnName = "id_job")
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;

    public Job() {
    }

    public Job(Long idJob) {
        this.idJob = idJob;
    }

    public Job(Long idJob, String nameJob, String descriptionJob, boolean statusJob) {
        this.idJob = idJob;
        this.nameJob = nameJob;
        this.descriptionJob = descriptionJob;
        this.statusJob = statusJob;
    }

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public String getNameJob() {
        return nameJob;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public String getDescriptionJob() {
        return descriptionJob;
    }

    public void setDescriptionJob(String descriptionJob) {
        this.descriptionJob = descriptionJob;
    }

    public boolean getStatusJob() {
        return statusJob;
    }

    public void setStatusJob(boolean statusJob) {
        this.statusJob = statusJob;
    }

    public Collection<LaborContract> getLaborContractCollection() {
        return laborContractCollection;
    }

    public void setLaborContractCollection(Collection<LaborContract> laborContractCollection) {
        this.laborContractCollection = laborContractCollection;
    }

    public Subprocess getSubprocess() {
        return subprocess;
    }

    public void setSubprocess(Subprocess subprocess) {
        this.subprocess = subprocess;
    }

    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJob != null ? idJob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.idJob == null && other.idJob != null) || (this.idJob != null && !this.idJob.equals(other.idJob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Job[ idJob=" + idJob + " ]";
    }
    
}
