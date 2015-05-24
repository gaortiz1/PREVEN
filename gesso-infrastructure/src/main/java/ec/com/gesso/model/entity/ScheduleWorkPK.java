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
    private Long idCompany;
	
    @Basic(optional = false)
    @Column(name = "id_business_hour")
    private String idBusinessHour;

	/**
	 * @return the idCompany
	 */
	public Long getIdCompany() {
		return idCompany;
	}

	/**
	 * @param idCompany the idCompany to set
	 */
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	/**
	 * @return the idBusinessHour
	 */
	public String getIdBusinessHour() {
		return idBusinessHour;
	}

	/**
	 * @param idBusinessHour the idBusinessHour to set
	 */
	public void setIdBusinessHour(String idBusinessHour) {
		this.idBusinessHour = idBusinessHour;
	}
}
