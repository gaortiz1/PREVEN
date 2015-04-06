/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorCompany implements IValidatorEntity<Company> {

	@Override
	public void validate(final Company company) {
		
		if (null == company) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == company.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == company.getIdTypeCompany()) {
			throw new ValidationEntity("El campo TypeCompany es null");
		}
		
		if (null == company.getIdProductiveSector()) {
			throw new ValidationEntity("El campo ProductiveSector es null");
		}
		
	}

}
