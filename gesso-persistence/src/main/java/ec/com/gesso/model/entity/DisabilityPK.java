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
public class DisabilityPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "id_disability")
    private long idDisability;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;

    public DisabilityPK() {
    }

    public DisabilityPK(long idDisability, long idPerson) {
        this.idDisability = idDisability;
        this.idPerson = idPerson;
    }

    public long getIdDisability() {
        return idDisability;
    }

    public void setIdDisability(long idDisability) {
        this.idDisability = idDisability;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }
}
