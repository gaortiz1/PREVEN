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
public class ScheduleWorkPK implements Serializable {
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

    public ScheduleWorkPK() {
    }

    public ScheduleWorkPK(long idCompany, int idBusinessHour) {
        this.idCompany = idCompany;
        this.idBusinessHour = idBusinessHour;
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
}
