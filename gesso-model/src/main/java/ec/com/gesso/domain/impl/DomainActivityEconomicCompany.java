/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainActivityEconomicCompany extends BaseDomainEntity<ActivityEconomicCompany> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IDomainEntity#register(java.io.Serializable)
	 */
	public ActivityEconomicCompany register(final ActivityEconomicCompany activityEconomicCompany) {
		
		this.validarActivityEconomicCompany(activityEconomicCompany);
		
		if (activityEconomicCompany.getId() == null){
			activityEconomicCompany.setState(Boolean.TRUE);
			this.repositoryEntity.create(activityEconomicCompany);
		} else {
			this.repositoryEntity.edit(activityEconomicCompany);
		}
		return activityEconomicCompany;
	}
	
	private void validarActivityEconomicCompany(final ActivityEconomicCompany activityEconomicCompany) {
		
		if (null == activityEconomicCompany) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == activityEconomicCompany.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == activityEconomicCompany.getIdCompany()) {
			throw new ValidationEntity("El campo id company es null");
		}
		
		if (null == activityEconomicCompany.getIdCompany()) {
			throw new ValidationEntity("El campo id compania es null");
		}
	}

}
