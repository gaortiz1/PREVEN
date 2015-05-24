/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "schedule_work")
public class ScheduleWork implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ScheduleWorkPK idScheduleWork;
    
    @Basic(optional = false)
    @Column(name = "state_company_schedule_work")
    private Boolean state;
    
    
    @OneToMany(mappedBy = "scheduleWork", fetch = FetchType.LAZY)
    private Collection<LaborContract> laborContractCollection;
    
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    
    @JoinColumn(name = "id_business_hour", referencedColumnName = "id_catalog", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Catalog businessHour;

	/**
	 * @return the idScheduleWork
	 */
	public ScheduleWorkPK getIdScheduleWork() {
		return idScheduleWork;
	}

	/**
	 * @param idScheduleWork the idScheduleWork to set
	 */
	public void setIdScheduleWork(ScheduleWorkPK idScheduleWork) {
		this.idScheduleWork = idScheduleWork;
	}

	/**
	 * @return the state
	 */
	public Boolean getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Boolean state) {
		this.state = state;
	}

	/**
	 * @return the laborContractCollection
	 */
	public Collection<LaborContract> getLaborContractCollection() {
		return laborContractCollection;
	}

	/**
	 * @param laborContractCollection the laborContractCollection to set
	 */
	public void setLaborContractCollection(
			Collection<LaborContract> laborContractCollection) {
		this.laborContractCollection = laborContractCollection;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the businessHour
	 */
	public Catalog getBusinessHour() {
		return businessHour;
	}

	/**
	 * @param businessHour the businessHour to set
	 */
	public void setBusinessHour(Catalog businessHour) {
		this.businessHour = businessHour;
	}
}
