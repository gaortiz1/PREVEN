/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "disability")
@NamedQueries({
    @NamedQuery(name = "Disability.findAll", query = "SELECT d FROM Disability d")})
public class Disability implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisabilityPK disabilityPK;
    @Basic(optional = false)
    @Column(name = "name_disability")
    private String nameDisability;
    @Basic(optional = false)
    @Column(name = "status_disability")
    private boolean statusDisability;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;

    public Disability() {
    }

    public Disability(DisabilityPK disabilityPK) {
        this.disabilityPK = disabilityPK;
    }

    public Disability(DisabilityPK disabilityPK, String nameDisability, boolean statusDisability) {
        this.disabilityPK = disabilityPK;
        this.nameDisability = nameDisability;
        this.statusDisability = statusDisability;
    }

    public Disability(long idDisability, long idPerson) {
        this.disabilityPK = new DisabilityPK(idDisability, idPerson);
    }

    public DisabilityPK getDisabilityPK() {
        return disabilityPK;
    }

    public void setDisabilityPK(DisabilityPK disabilityPK) {
        this.disabilityPK = disabilityPK;
    }

    public String getNameDisability() {
        return nameDisability;
    }

    public void setNameDisability(String nameDisability) {
        this.nameDisability = nameDisability;
    }

    public boolean getStatusDisability() {
        return statusDisability;
    }

    public void setStatusDisability(boolean statusDisability) {
        this.statusDisability = statusDisability;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
