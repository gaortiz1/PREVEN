/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorActivityEconomic implements IValidatorEntity<ActivityEconomicCompany> {

	@Override
	public void validate(final ActivityEconomicCompany activityEconomicCompany) {
		
		if (null == activityEconomicCompany) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == activityEconomicCompany.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == activityEconomicCompany.getIdCompany()) {
			throw new ValidationEntity("El campo id compania es null");
		}
		
	}

}
