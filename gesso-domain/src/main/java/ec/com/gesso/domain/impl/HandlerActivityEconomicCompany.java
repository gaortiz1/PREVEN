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
public class HandlerActivityEconomicCompany extends BaseHandlerEntity<ActivityEconomicCompany> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IHandlerEntity#register(java.io.Serializable)
	 */
	public ActivityEconomicCompany register(final ActivityEconomicCompany activityEconomicCompany) {
		
		this.validarActivityEconomicCompany(activityEconomicCompany);
		
		if (activityEconomicCompany.getId() == null){
			activityEconomicCompany.setState(Boolean.TRUE);
			this.repositoryEntity.add(activityEconomicCompany);
		} else {
			this.repositoryEntity.update(activityEconomicCompany);
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
		
		if (null == activityEconomicCompany.getIdTypeActivity()) {
			throw new ValidationEntity("El campo id type activity es null");
		}
	}

}
