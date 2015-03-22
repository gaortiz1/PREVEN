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
@Table(name = "capacitation")
@NamedQueries({
    @NamedQuery(name = "Capacitation.findAll", query = "SELECT c FROM Capacitation c")})
public class Capacitation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitationPK capacitationPK;
    @Basic(optional = false)
    @Column(name = "description_capacitation")
    private String descriptionCapacitation;
    @Basic(optional = false)
    @Column(name = "status_capacitation")
    private boolean statusCapacitation;
    @Column(name = "hours")
    @Temporal(TemporalType.DATE)
    private Date hours;
    @JoinColumns({
        @JoinColumn(name = "id_cv", referencedColumnName = "id_cv", insertable = false, updatable = false),
        @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CurriculumVitae curriculumVitae;

    public Capacitation() {
    }

    public Capacitation(CapacitationPK capacitationPK) {
        this.capacitationPK = capacitationPK;
    }

    public Capacitation(CapacitationPK capacitationPK, String descriptionCapacitation, boolean statusCapacitation) {
        this.capacitationPK = capacitationPK;
        this.descriptionCapacitation = descriptionCapacitation;
        this.statusCapacitation = statusCapacitation;
    }

    public Capacitation(long idCv, long idPerson, int idCapacitation) {
        this.capacitationPK = new CapacitationPK(idCv, idPerson, idCapacitation);
    }

    public CapacitationPK getCapacitationPK() {
        return capacitationPK;
    }

    public void setCapacitationPK(CapacitationPK capacitationPK) {
        this.capacitationPK = capacitationPK;
    }

    public String getDescriptionCapacitation() {
        return descriptionCapacitation;
    }

    public void setDescriptionCapacitation(String descriptionCapacitation) {
        this.descriptionCapacitation = descriptionCapacitation;
    }

    public boolean getStatusCapacitation() {
        return statusCapacitation;
    }

    public void setStatusCapacitation(boolean statusCapacitation) {
        this.statusCapacitation = statusCapacitation;
    }

    public Date getHours() {
        return hours;
    }

    public void setHours(Date hours) {
        this.hours = hours;
    }

    public CurriculumVitae getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }
}
