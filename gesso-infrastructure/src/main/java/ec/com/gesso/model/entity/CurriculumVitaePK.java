/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roberto
 */
@Embeddable
public class CurriculumVitaePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "id_cv")
    private long idCv;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;

    public CurriculumVitaePK() {
    }

    public CurriculumVitaePK(long idCv, long idPerson) {
        this.idCv = idCv;
        this.idPerson = idPerson;
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
}
