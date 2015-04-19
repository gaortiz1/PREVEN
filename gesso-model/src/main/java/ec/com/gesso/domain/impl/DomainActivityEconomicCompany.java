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

	@Override
	public ActivityEconomicCompany create(final ActivityEconomicCompany activityEconomicCompany) {
		
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
		
		activityEconomicCompany.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(activityEconomicCompany);
	}

}
