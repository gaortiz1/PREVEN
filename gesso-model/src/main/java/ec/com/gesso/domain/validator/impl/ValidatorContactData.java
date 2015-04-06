/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorContactData implements IValidatorEntity<ContactData> {

	@Override
	public void validate(final ContactData contactData) {
		
		if (null == contactData) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
	}

}
