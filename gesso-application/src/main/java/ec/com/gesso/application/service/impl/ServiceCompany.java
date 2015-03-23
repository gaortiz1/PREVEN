/**
 * 
 */
package ec.com.gesso.application.service.impl;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Company;

/**
 * @author Gabriel
 *
 */
public class ServiceCompany implements IServiceEntity<Company> {
	
	private IDomainEntity<Company> domainCompany;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.application.service.IServiceEntity#create(java.io.Serializable)
	 */
	public Company create(final Company company) {
		return this.domainCompany.create(company);
	}

	/**
	 * @param domainCompany the domainCompany to set
	 */
	public void setDomainCompany(IDomainEntity<Company> domainCompany) {
		this.domainCompany = domainCompany;
	}
}