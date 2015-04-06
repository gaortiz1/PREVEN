/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorEmail implements IValidatorEntity<Email> {

	@Override
	public void validate(final Email email) {
		
		if (null == email) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == email.getIdContactData()) {
			throw new ValidationEntity("El campo contact data es null");
		}
		
		if (null == email.getEmailaddess()) {
			throw new ValidationEntity("El campo email es null");
		}
		
	}

}
