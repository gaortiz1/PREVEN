/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

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
@Table(name = "curriculum_vitae")
@NamedQueries({
    @NamedQuery(name = "CurriculumVitae.findAll", query = "SELECT c FROM CurriculumVitae c")})
public class CurriculumVitae implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CurriculumVitaePK curriculumVitaePK;
    @Basic(optional = false)
    @Column(name = "occupation")
    private String occupation;
    @Basic(optional = false)
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "status_curriculum_vitae")
    private boolean statusCurriculumVitae;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumVitae", fetch = FetchType.LAZY)
    private Collection<LaborContract> laborContractCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumVitae", fetch = FetchType.LAZY)
    private Collection<Experience> experienceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumVitae", fetch = FetchType.LAZY)
    private Collection<Capacitation> capacitationCollection;

    public CurriculumVitae() {
    }

    public CurriculumVitae(CurriculumVitaePK curriculumVitaePK) {
        this.curriculumVitaePK = curriculumVitaePK;
    }

    public CurriculumVitae(CurriculumVitaePK curriculumVitaePK, String occupation, String photo, boolean statusCurriculumVitae) {
        this.curriculumVitaePK = curriculumVitaePK;
        this.occupation = occupation;
        this.photo = photo;
        this.statusCurriculumVitae = statusCurriculumVitae;
    }

    public CurriculumVitae(long idCv, long idPerson) {
        this.curriculumVitaePK = new CurriculumVitaePK(idCv, idPerson);
    }

    public CurriculumVitaePK getCurriculumVitaePK() {
        return curriculumVitaePK;
    }

    public void setCurriculumVitaePK(CurriculumVitaePK curriculumVitaePK) {
        this.curriculumVitaePK = curriculumVitaePK;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean getStatusCurriculumVitae() {
        return statusCurriculumVitae;
    }

    public void setStatusCurriculumVitae(boolean statusCurriculumVitae) {
        this.statusCurriculumVitae = statusCurriculumVitae;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection<LaborContract> getLaborContractCollection() {
        return laborContractCollection;
    }

    public void setLaborContractCollection(Collection<LaborContract> laborContractCollection) {
        this.laborContractCollection = laborContractCollection;
    }

    public Collection<Experience> getExperienceCollection() {
        return experienceCollection;
    }

    public void setExperienceCollection(Collection<Experience> experienceCollection) {
        this.experienceCollection = experienceCollection;
    }

    public Collection<Capacitation> getCapacitationCollection() {
        return capacitationCollection;
    }

    public void setCapacitationCollection(Collection<Capacitation> capacitationCollection) {
        this.capacitationCollection = capacitationCollection;
    }
}
