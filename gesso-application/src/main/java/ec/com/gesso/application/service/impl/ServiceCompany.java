/**
 * 
 */
package ec.com.gesso.application.service.impl;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.model.entity.Company;

/**
 * @author Gabriel
 *
 */
public class ServiceCompany implements IServiceEntity<Company> {
	
	private IHandlerEntity<Company> handlerCompany;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.application.service.IServiceEntity#create(java.io.Serializable)
	 */
	public Company register(final Company company) {
		return this.handlerCompany.register(company);
	}

	/**
	 * @param handlerCompany the handlerCompany to set
	 */
	public void setHandlerCompany(IHandlerEntity<Company> handlerCompany) {
		this.handlerCompany = handlerCompany;
	}
}