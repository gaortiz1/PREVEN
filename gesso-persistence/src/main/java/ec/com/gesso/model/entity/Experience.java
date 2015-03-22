/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

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
@Table(name = "experience")
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e")})
public class Experience implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExperiencePK experiencePK;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumns({
        @JoinColumn(name = "id_cv", referencedColumnName = "id_cv", insertable = false, updatable = false),
        @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CurriculumVitae curriculumVitae;

    public Experience() {
    }

    public Experience(ExperiencePK experiencePK) {
        this.experiencePK = experiencePK;
    }

    public Experience(ExperiencePK experiencePK, String description, Date startDate, Date endDate) {
        this.experiencePK = experiencePK;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Experience(long idCv, long idPerson, long idExperience) {
        this.experiencePK = new ExperiencePK(idCv, idPerson, idExperience);
    }

    public ExperiencePK getExperiencePK() {
        return experiencePK;
    }

    public void setExperiencePK(ExperiencePK experiencePK) {
        this.experiencePK = experiencePK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public CurriculumVitae getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }
    
}
