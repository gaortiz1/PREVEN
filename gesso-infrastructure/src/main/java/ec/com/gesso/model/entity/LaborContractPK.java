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
public class LaborContractPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "id_company")
    private long idCompany;
    @Basic(optional = false)
    @Column(name = "id_business_hour")
    private int idBusinessHour;
    @Basic(optional = false)
    @Column(name = "id_cv")
    private long idCv;
    @Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;
    @Basic(optional = false)
    @Column(name = "id_job")
    private long idJob;

    public LaborContractPK() {
    }

    public LaborContractPK(long idCompany, int idBusinessHour, long idCv, long idPerson, long idJob) {
        this.idCompany = idCompany;
        this.idBusinessHour = idBusinessHour;
        this.idCv = idCv;
        this.idPerson = idPerson;
        this.idJob = idJob;
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

    public long getIdJob() {
        return idJob;
    }

    public void setIdJob(long idJob) {
        this.idJob = idJob;
    }
}
